package mtis.proyecto.empresa.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import mtis.proyecto.empresa.business.EmployeeBO;
import mtis.proyecto.empresa.persistance.EmployeeDAO;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/empleado/{dni}")
@Produces("application/json")
public class EmployeeREST {

	@Context
	UriInfo uri;

	/**
	 * Method processing HTTP GET requests, producing "application/json" MIME
	 * media type.
	 * 
	 * @return String that will be send back as a response of type
	 *         "application/json".
	 */
	@GET
	public Response get(@PathParam("dni") String dni) {

		Response response;
		String JSON = "";
		String error = "No se ha encontrado el recurso.";

		/*
		 * IncidenciaBO incidencia = new IncidenciaBO();
		 * 
		 * incidencia.setId(Long.valueOf(idString)); incidencia.setLatitud(1);
		 * incidencia.setLongitud(2); incidencia.setTermino("Termino");
		 * incidencia.setAccion("Acción");
		 */

		// Poblamos "incidencias" con una incidencia 1
		if (EmployeeDAO.get("1") == null) {
			EmployeeBO prePopulatedEmployee = new EmployeeBO();
			prePopulatedEmployee.setDni("1");
			prePopulatedEmployee.setSocialSecurityNumber("1");
			prePopulatedEmployee.setName("Name 1");
			prePopulatedEmployee.setLastname1("Lastname1");
			prePopulatedEmployee.setLastname2("Lastname2");
			
			EmployeeDAO.save(prePopulatedEmployee);
		}
		
		EmployeeBO incidencia = EmployeeDAO.get(dni);

		if (incidencia != null) {
			JSON = incidencia.toJSON();
			response = Response.ok(JSON).build();
		} else {
			response = Response.status(404).entity(error).type("text/plain").build();
		}

		return response;
	}

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
}
