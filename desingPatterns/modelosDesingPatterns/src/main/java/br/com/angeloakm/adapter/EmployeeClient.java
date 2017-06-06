package br.com.angeloakm.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

	public List<Employee> getEmployeeList() {

		List<Employee> employess = new ArrayList<Employee>();

		Employee employeeFromDB = new EmployeeDB("123", "Neo", "white@rabbit.com");

		/**
		 * Isso não funciona pois a classe EmployeeLDAP é uma classe ja feita e
		 * não queremos modifica-la pois teoricamente ja esta sendo usada a
		 * muito tempo
		 */
		// Employee employeeFromLDAP = new EmployeeLDAP("456", "Kenshin", "himura@batoussai.com");

		/**
		 * Então para obter esta lista de funcionarios criamos um "Adapter"
		 */
		EmployeeLDAP employeeLDAP = new EmployeeLDAP("456", "Kenshin", "himura@batoussai.com");

		/**
		 * EmployeeAdapterLDAP será o nosso Adapter
		 */
		employess.add(new EmployeeAdapterLDAP(employeeLDAP));

		employess.add(employeeFromDB);

		return employess;

	}

}
