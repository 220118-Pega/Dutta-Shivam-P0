package com.revature.reimbursement.bl;

import java.util.List;

import com.revature.reimbursement.dl.DBRepository;
import com.revature.reimbursements.models.Employee;

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
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
