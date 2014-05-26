package proyectomtis.business;

import java.io.IOException;

import mtis.proyecto.empresa.business.EmployeeBO;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSON {

	public static String marshall(Object object) {

		String json = "";

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		try {
			json = mapper.writeValueAsString(object);
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

		return json;

	}

	public static Object unmarshall(String json, Class objectClass) {

		Object object = null;

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		try {
			object = mapper.readValue(json, objectClass);
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

		return object;
	}
}
