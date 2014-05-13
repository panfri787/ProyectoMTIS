package esb;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import proyectomtis.ws.soap.client.DniIdAndBusinessId;
import proyectomtis.ws.soap.client.FireEmployee;
import proyectomtis.ws.soap.client.FireEmployeePortType;
import proyectomtis.ws.soap.client.IsOkAndFireEmployeeReport;



public class CallFireEmployeeBPEL_SOAP {

	public static IsOkAndFireEmployeeReport call(
			FireEmployeeRequestParameters requestParameters) {

		DniIdAndBusinessId dniIdAndBusinessId = new DniIdAndBusinessId();
		
		dniIdAndBusinessId.setDniId(requestParameters.getDniNumber());
		dniIdAndBusinessId.setBusinessId(requestParameters.getBusinessId());
						
		FireEmployee service = new FireEmployee();
		FireEmployeePortType client = service.getFireEmployeeSOAP();
		 
		IsOkAndFireEmployeeReport isOkAndFireEmployeeReport = client.fireEmployee(dniIdAndBusinessId);
		
		return isOkAndFireEmployeeReport;
		//return toJSON(isOkAndFireEmployeeReport);
	}
	
	private static String toJSON(IsOkAndFireEmployeeReport isOkAndFireEmployeeReport) {
		String JSON = "";

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		try {
			JSON = mapper.writeValueAsString(isOkAndFireEmployeeReport);
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
