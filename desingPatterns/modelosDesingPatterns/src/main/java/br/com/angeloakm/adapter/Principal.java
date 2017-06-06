package br.com.angeloakm.adapter;

import java.util.List;

public class Principal {

	public static void main(String[] args) {

		EmployeeClient client = new EmployeeClient();

		List<Employee> employees = client.getEmployeeList();

		System.out.println(employees);

	}

}
