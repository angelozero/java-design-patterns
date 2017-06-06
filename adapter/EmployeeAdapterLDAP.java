package br.com.angeloakm.adapter;

public class EmployeeAdapterLDAP implements Employee {

	private EmployeeLDAP employee;

	public EmployeeAdapterLDAP(EmployeeLDAP employee) {
		this.employee = employee;
	}

	public String getId() {
		return this.employee.getIndentificationNumber();
	}

	public String getName() {
		return this.employee.getNameFromEmployee();
	}

	public String getEmail() {
		return this.employee.getEmailFromEmployee();
	}

	@Override
	public String toString() {

		return "ID: " + employee.getIndentificationNumber() 
				+ " Name: " + employee.getNameFromEmployee() 
				+ " Email: " + employee.getEmailFromEmployee();
	}

}
