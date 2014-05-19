package proyectomtis.ws.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import proyectomtis.models.EmployeeTO;
import proyectomtis.persistance.EmployeeDAO;



/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/fireEmployeeJMS")
@Consumes("application/json")
public class FireEmployeeJmsResource {
	
	@XmlRootElement
	public static class MyJaxBean{
	    @XmlElement public String dniNumber;
	    @XmlElement public String businessId;
	}

	/**
	 * Method processing HTTP GET requests, producing "application/json" MIME
	 * media type.
	 * @return 
	 * 
	 * @return String that will be send back as a response of type
	 *         "application/json".
	 * @throws JMSException 
	 */
	
@POST	
public Response post(final MyJaxBean input) throws JMSException {

		
		// URL of the JMS server.
				String url = "tcp://localhost:61616";
				// Name of the topic we will be sending messages to
			    String subject = "prueba";
			    
			    // Getting JMS connection from the server and starting it
		        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		        Connection connection = connectionFactory.createConnection();
		        connection.start();
		        
		        // JMS messages are sent and received using a Session. We will
		        // create here a non-transactional session object. If you want
		        // to use transactions you should set the first parameter to 'true'
		        Session session = connection.createSession(false,
		            Session.AUTO_ACKNOWLEDGE);

		        // Destination represents here our topic 'historiales' on the
		        // JMS server. You don't have to do anything special on the
		        // server to create it, it will be created automatically.
		        Destination destination = session.createTopic(subject);

		        // MessageProducer is used for sending messages (as opposed
		        // to MessageConsumer which is used for receiving them)
		        MessageProducer producer = session.createProducer(destination);
		        
		        
		Response response;
		String JSON = "";
		String error = "Error: Employee list not accesible";
		
		

		if (input != null) {
			JSON = toJSON(input);
			response = Response.ok("").build();
		} else {
			response = Response.status(404).entity(error).type("text/plain").build();
		}
		
		TextMessage message = session.createTextMessage("" + JSON);
		producer.send(message);
		connection.close();
		return response;
				
	}


/*
	@PUT
	//TODO Solucionar error de unsuported media type al mandar JSON
	//@Consumes("application/json")
	public Response put(String resourceJSON) {

		Response response;
		String error = "No se ha podido crear/modificar el recurso";

		EmployeeBO employee = EmployeeBO.newFromJSON(resourceJSON);

		if (employee != null) {
			EmployeeDAO.save(employee);

			// TODO Componer la uri con la location del recurso creado

			// String baseUri = uri.getBaseUri().toString();
			// String resourceUri = baseUri + "incidencia/" +
			// incidencia.getId();
			// response = Response.created(resourceUri).build();
			response = Response.status(201).build();
		} else {
			response = Response.status(400).entity(error).type("text/plain").build();
		}

		return response;

	}
*/
	public String toJSON(MyJaxBean input) {
		String JSON = "";

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		try {
			JSON = mapper.writeValueAsString(input);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JSON;
	}
}