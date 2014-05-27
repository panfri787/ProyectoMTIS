package proyectomtis.persistance;

import java.util.ArrayList;
import java.util.HashMap;

import mtis.proyecto.empresa.business.EmployeeBO;
import proyectomtis.models.EmployeeTO;
import proyectomtis.ws.soap.fireemployee.IsOkAndFireEmployeeReport;

public class IsOkAndFireEmployeeReportDAO {

	private static HashMap<Integer, IsOkAndFireEmployeeReport> isOkAndFireEmployeeReports = new HashMap<Integer, IsOkAndFireEmployeeReport>();
	
	private static boolean isPrepopulated = false;

	public static void save(IsOkAndFireEmployeeReport isOkAndFireEmployeeReport) {
		
		isOkAndFireEmployeeReports.put(isOkAndFireEmployeeReport.getFireEmployeeReport().getProcessId(), isOkAndFireEmployeeReport);
	}
	
	public static IsOkAndFireEmployeeReport get(int processId) {
		
		return isOkAndFireEmployeeReports.get(processId);
	}
	
	public static ArrayList<IsOkAndFireEmployeeReport> getAll() {

		System.out.println("EmployeeDAO.getAll() employees.size() = " + isOkAndFireEmployeeReports.size());
		
		return new ArrayList<IsOkAndFireEmployeeReport>(isOkAndFireEmployeeReports.values());
	}

}
