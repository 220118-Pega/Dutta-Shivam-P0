package com.revature.reimbursements.models;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private int phoneNumber;
	
	public Employee() {
		
	}
	
	public Employee(int employeeId, String employeeName,int phoneNumber) {
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.phoneNumber=phoneNumber;
	}

	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	

}
