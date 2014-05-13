package proyectomtis.ws.rest;


import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import proyectomtis.models.EmployeeTO;
import proyectomtis.persistance.EmployeeDAO;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/employees")
@Produces("application/json")
public class EmployeesREST {

	/**
	 * Method processing HTTP GET requests, producing "application/json" MIME
	 * media type.
	 * 
	 * @return String that will be send back as a response of type
	 *         "application/json".
	 */
	@GET
	public Response get() {

		Response response;
		String JSON = "";
		String error = "Error: Employee list not accesible";
		
		ArrayList<EmployeeTO> employees = EmployeeDAO.getAll();

		if (employees != null) {
			JSON = toJSON(employees);
			response = Response.ok(JSON).build();
		} else {
			response = Response.status(404).entity(error).type("text/plain").build();
		}

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
	public String toJSON(ArrayList<EmployeeTO> employees) {
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
	}
}