package com.revature.reimbursement.bl;

import java.util.List;


import com.revature.reimbursements.models.Employee;


public interface IEmployeeBL {
	void addEmployee(Employee employee);
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(int id);

	
	
}
