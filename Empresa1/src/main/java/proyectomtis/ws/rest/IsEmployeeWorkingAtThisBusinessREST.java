package proyectomtis.ws.rest;


import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import proyectomtis.models.EmployeeTO;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/isEmployeeWorkingAtThisBusiness")
@Produces("application/json")
public class IsEmployeeWorkingAtThisBusinessREST {

	/**
	 * Method processing HTTP GET requests, producing "application/json" MIME
	 * media type.
	 * 
	 * @return String that will be send back as a response of type
	 *         "application/json".
	 */
	@GET
	public Response get(@QueryParam("dni") String dni) {

		Response response;
		String JSON = "";
		String error = "Error: Employee list not accesible";
		
		//ArrayList<EmployeeTO> employees = EmployeeDAO.getAll();
		boolean isValidDni = true;
		Boolean ok = false;
		
		System.out.println("Se hace la llamada REST");
		if (isValidDni) {
			if (dni.substring(dni.length() - 1).equals("T")){
				ok = true;
			} else {
				ok = false;
			}
			JSON = "{\"ok\": \""+ok.toString()+"\", \"error\": \"\"}";
			response = Response.ok(JSON).build();
		} else {
			response = Response.status(404).entity(error).type("text/plain").build();
		}

		return response;
	}

	/*public String toJSON(ArrayList<EmployeeTO> employees) {
		String JSON = "";

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		try {
			JSON = mapper.writeValueAsString(employees);
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
	}*/
}
