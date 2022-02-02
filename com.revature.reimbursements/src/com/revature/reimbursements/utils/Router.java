package com.revature.reimbursements.utils;

import com.revature.reimbursements.controllers.EController;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

import io.javalin.Javalin;

public class Router {
	private Javalin app;
	private EController employeeController;
	private EController ticketController;
	
	public Router(Javalin app, EController employeeController,EController ticketController) {
		this.app = app;
		this.employeeController = employeeController;
		this.ticketController=ticketController;
	}
	
	public void setUpEndPoints() {
		app.get("/Employees", OpenApiBuilder.documented(DocumentationFactory.getDoc("getEmployees"),employeeController.getAll()));
		app.get("/Employees/{Employee_id}/tickets",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getEmployeeById"),employeeController.getById()));
		app.post("/Employees",OpenApiBuilder.documented(DocumentationFactory.getDoc("addEmployee"), employeeController.add()));
		app.get("/tickets", OpenApiBuilder.documented(DocumentationFactory.getDoc("getTickets"),ticketController.getAll()));
		app.get("/tickets/{Employee_id}/tickets",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getTicketByEmployeeId"),ticketController.getById()));
		app.post("/tickets",OpenApiBuilder.documented(DocumentationFactory.getDoc("addTicket"), ticketController.add()));
		app.put("/tickets/{ticket_id}",OpenApiBuilder.documented(DocumentationFactory.getDoc("updateTicket"), ticketController.update()));
		
	}

}
