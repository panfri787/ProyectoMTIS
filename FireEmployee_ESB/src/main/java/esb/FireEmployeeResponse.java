package esb;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import proyectomtis.ws.soap.client.FireEmployeeReport;

@JsonAutoDetect
public class FireEmployeeResponse {

	private boolean isCompletedWithoutErrors;
	private FireEmployeeReport fireEmployeeReport;

	public boolean isCompletedWithoutErrors() {
		return isCompletedWithoutErrors;
	}

	public void setCompletedWithoutErrors(boolean isCompletedWithoutErrors) {
		this.isCompletedWithoutErrors = isCompletedWithoutErrors;
	}

	public FireEmployeeReport getFireEmployeeReport() {
		return fireEmployeeReport;
	}

	public void setFireEmployeeReport(FireEmployeeReport fireEmployeeReport) {
		this.fireEmployeeReport = fireEmployeeReport;
	}

}
