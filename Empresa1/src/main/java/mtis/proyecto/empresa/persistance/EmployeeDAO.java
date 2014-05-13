package mtis.proyecto.empresa.persistance;

import java.util.HashMap;

import mtis.proyecto.empresa.business.EmployeeBO;

public class EmployeeDAO {

	private static HashMap<String, EmployeeBO> employees = new HashMap<String, EmployeeBO>();
	
	public static void save(EmployeeBO employee) {
				
		employees.put(employee.getDni(), employee);
	}
	
	public static EmployeeBO get(String dni) {
		
		return employees.get(dni);
	}
	
}
