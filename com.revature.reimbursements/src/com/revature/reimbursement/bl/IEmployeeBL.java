package com.revature.reimbursement.bl;

import java.util.List;


import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;


public interface IEmployeeBL {
	void addEmployee(Employee employee);
	
	List<Employee> getEmployees() throws Exception;
	
	Employee getEmployeeById(int id);
	
	void updateEmployee(Employee newEmployee);

//	List<RefundTicket> getTicketsByEmployeeId(int employee_id);
	
	
}
