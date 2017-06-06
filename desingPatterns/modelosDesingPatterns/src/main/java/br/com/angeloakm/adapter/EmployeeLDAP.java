package br.com.angeloakm.adapter;

public class EmployeeLDAP {

	private String indentificationNumber;
	private String nameFromEmployee;
	private String emailFromEmployee;

	public EmployeeLDAP(String indentificationNumber, String nameFromEmployee, String emailFromEmployee) {
		this.indentificationNumber = indentificationNumber;
		this.nameFromEmployee = nameFromEmployee;
		this.emailFromEmployee = emailFromEmployee;
	}

	public String getIndentificationNumber() {
		return indentificationNumber;
	}

	public void setIndentificationNumber(String indentificationNumber) {
		this.indentificationNumber = indentificationNumber;
	}

	public String getNameFromEmployee() {
		return nameFromEmployee;
	}

	public void setNameFromEmployee(String nameFromEmployee) {
		this.nameFromEmployee = nameFromEmployee;
	}

	public String getEmailFromEmployee() {
		return emailFromEmployee;
	}

	public void setEmailFromEmployee(String emailFromEmployee) {
		this.emailFromEmployee = emailFromEmployee;
	}

}
