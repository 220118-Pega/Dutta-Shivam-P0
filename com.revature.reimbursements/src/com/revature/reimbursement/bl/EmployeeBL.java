package com.revature.reimbursement.bl;

import java.util.List;

import com.revature.reimbursement.dl.DBRepository;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

public class EmployeeBL implements IEmployeeBL{
	private DBRepository dbRepo;
	
	public EmployeeBL(DBRepository dbRepo) {
		this.dbRepo=dbRepo;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		dbRepo.addEmployee(employee);
	}

	@Override
	public List<Employee> getEmployees() throws Exception {
		return dbRepo.getEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dbRepo.getEmployeeById(id);
	}

	@Override
	public void updateEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		dbRepo.updateEmployee(newEmployee);
	}
	
}
