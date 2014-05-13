package esb;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class FireEmployeeRequestParameters {
	private String businessId;
	private String dniNumber;

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getDniNumber() {
		return dniNumber;
	}

	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}

}
