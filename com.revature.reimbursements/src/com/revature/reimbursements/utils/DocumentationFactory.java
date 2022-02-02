package com.revature.reimbursements.utils;

import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;

public class DocumentationFactory {
	public static OpenApiDocumentation getDoc(String endPoint) {
		switch(endPoint) {
		case "getEmployees":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Employee");
			}).jsonArray("200",Employee.class);
		case "getEmployeeById":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Employee");
			}).json("200", Employee.class);
		case "addEmployee":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Employee");
			}).body(Employee.class).result("201");
		case "getTickets":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).jsonArray("200",RefundTicket.class);
		case "getTicketByEmployeeId":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).json("200", RefundTicket.class);
		case "addTicket":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).body(RefundTicket.class).result("201");
		case "updateTicket":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).body(RefundTicket.class).result("201");
		case "getFilteredTickets":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Tickets");
			}).jsonArray("200",RefundTicket.class);
		default:
			return null;
		}
	}
	

}
