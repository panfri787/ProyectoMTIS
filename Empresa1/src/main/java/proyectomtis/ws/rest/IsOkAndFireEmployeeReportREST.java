package proyectomtis.ws.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import proyectomtis.business.JSON;
import proyectomtis.persistance.IsOkAndFireEmployeeReportDAO;
import proyectomtis.ws.soap.fireemployee.IsOkAndFireEmployeeReport;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/isOkAndFireEmployeeReports")
@Produces("application/json")
public class IsOkAndFireEmployeeReportREST {

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
		String json = "";
		String error = "Error: IsOkAndFireEmployeeReport list not accesible";
		
		ArrayList<IsOkAndFireEmployeeReport> IsOkAndFireEmployeeReports = IsOkAndFireEmployeeReportDAO.getAll();

		if (IsOkAndFireEmployeeReports != null) {
			json = JSON.marshall(IsOkAndFireEmployeeReports);
			response = Response.ok(json).build();
		} else {
			response = Response.status(404).entity(error).type("text/plain").build();
		}

		return response;
	}

	@POST
	//TODO Solucionar error de unsuported media type al mandar JSON
	//@Consumes("application/json")
	public Response put(String resourceJSON) {

		Response response;
		String error = "No se ha podido crear/modificar el recurso";

		IsOkAndFireEmployeeReport resource = (IsOkAndFireEmployeeReport) JSON.unmarshall(resourceJSON, IsOkAndFireEmployeeReport.class);

		if (resource != null) {
			IsOkAndFireEmployeeReportDAO.save(resource);

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