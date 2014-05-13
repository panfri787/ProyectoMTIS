package proyectomtis.persistance;

import java.util.ArrayList;
import java.util.HashMap;

import mtis.proyecto.empresa.business.EmployeeBO;
import proyectomtis.models.EmployeeTO;
import proyectomtis.models.EmployeeTO.Dni;

public class EmployeeDAO {

	private static HashMap<String, EmployeeTO> employees = new HashMap<String, EmployeeTO>();

	private static boolean isPrepopulated = false;

	public static void save(EmployeeTO employee) {

		if (!isPrepopulated)
			prepopulate();

		employees.put(employee.dni.getDni().getId(), employee);
	}

	public static EmployeeTO get(String dni) {

		if (!isPrepopulated)
			prepopulate();
		
		return employees.get(dni);
	}

	public static ArrayList<EmployeeTO> getAll() {

		if (!isPrepopulated)
			prepopulate();
		
		System.out.println("EmployeeDAO.getAll() employees.size() = " + employees.size());
		
		return new ArrayList<EmployeeTO>(employees.values());
	}

	private static void prepopulate() {

		isPrepopulated = true;
		
		EmployeeTO employee;

		employee = new EmployeeTO("1");
		save(employee);

		employee = new EmployeeTO("2");
		save(employee);

		employee = new EmployeeTO("3");
		save(employee);
		
	}

}
