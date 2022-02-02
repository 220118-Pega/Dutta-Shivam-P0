package com.revature.reimbursements.controllers;

import com.revature.reimbursement.bl.IEmployeeBL;
import com.revature.reimbursements.models.Employee;

import io.javalin.http.Handler;

public class EmployeeController implements EController{
	private IEmployeeBL employeeBL;
	
	public EmployeeController(IEmployeeBL employeeBL) {
		this.employeeBL=employeeBL;
	}
	@Override
	public Handler getAll() {
		// Handler is a functional interface
		// A means to pass function as parameters
		//	we'll be returning a lambda function	
		return ctx -> {
			ctx.jsonStream(employeeBL.getEmployees());
		};
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return ctx -> {
			String id = ctx.pathParam("Employee_id");
			int actualId = Integer.parseInt(id);
			try {
				
				ctx.jsonStream(employeeBL.getEmployeeById(actualId));
			}catch(NullPointerException ex) {
				ctx.res.setStatus(204);
			}
		};
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			Employee newEmployee = ctx.bodyAsClass(Employee.class);
			try {
				employeeBL.addEmployee(newEmployee);
				ctx.status(201);
			}catch(Exception e) {
				
			}
				
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return null;
	}

}
