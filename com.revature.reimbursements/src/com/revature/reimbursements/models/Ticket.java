package com.revature.reimbursements.models;

import java.time.Instant;

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;

public class Ticket {
	
//	fields for ticket class-->
	private Status status;                //This field describes the status of Reimbursement (i.e status: approved,pending or declined)
	private Reimbursement type;           //This field describes the reason to issue reimbursement (i.e lodging, food, travel ...)
	private Instant timestamp;            // This field describes at what time ticket is raised
	private String description;           // This field describes the optional comment
	private int employeeId;               // This sets the employee Id
	private int id;                       // This field describes the transaction id
	private double amount;                // This field describes the transaction amount
	
	
	
//	constructor for ticket class without "Description"
//	If person doesn't choose to write description 
	
	public Ticket(int employeeId, Reimbursement type,double amount) {
		this.employeeId=employeeId;
		this.type=type;
		this.amount=amount;
		
//		Set Other fields to default -->>
		this.timestamp= Instant.now();
		this.status=Status.PENDING;
		this.id=0;
		this.description="No Description";
		
	}
	

//	constructor for ticket class -->
	
	public Ticket(int employeeId,Reimbursement type,double amount,String description) {
		this(employeeId,type,amount);
		this.description=description;
		
	}
	
	public Ticket() {
		this(2,Reimbursement.FOOD,70,"None");
	}
	
	
//	public Ticket() {
//		this.type = Reimbursement.
//		this(7,Type.Travel,70.0,"Auto generated ticket");
//	}

	
//	Getters and setters for ticket class -->

	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Reimbursement getType() {
		return type;
	}


	public void setType(Reimbursement type) {
		this.type = type;
	}


	public Instant getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
		


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
		
	@Override
	public String toString() {
		return "Ticket is " + status + "\nAmount: " + amount + "\ndescription is:  "+description + "\nTime is: " + timestamp;
	}

	
	
	
}
