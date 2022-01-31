package com.revature.reimbursements.ui;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.revature.reimbursement.bl.IEmployeeBL;
import com.revature.reimbursement.bl.ITicketBL;
import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

public class MainMenu {
	
	private Scanner myScanner;
	private ITicketBL ticketBL;
	private IEmployeeBL employeeBL;
//	private final Logger myLogger = LogManager.getLogger(this.getClass());


	public MainMenu(Scanner myScanner,ITicketBL ticketBL,IEmployeeBL employeeBL) {
		this.myScanner=myScanner;
		this.ticketBL = ticketBL;
		this.employeeBL=employeeBL;
	}
	
	
	public void start() throws Exception {		
		boolean isDone = true;
		while(isDone) { 			
			System.out.println("How would you like to interact with the reimburse tickets \n "
					           + "[1] Create ticket \n "
					           + "[2] View Specific ticket \n "
					           + "[3] View all Employee tickets \n "
					           + "[4] Update ticket status"
					           + "[x] Exit");
			
			//Asking the user for the input via console using "scanner.nextline()"
			String myOption = myScanner.nextLine();
			
			switch(myOption) {
				case "1":
					System.out.println("Creating ticket....");
					createTicket();
					break;
				case "2":
					System.out.println("View specific ticket.....");
					viewTicketById();
					break;
				case "3":
					System.out.println("Viewing all Employee tickets");
					viewAllEmpTicket();
					break;
				case "4":
					System.out.println("Updating ticket ....");
					updateTicket();
					break;
				case "x":
					System.out.println("exit");
					break;
					
					default:
						break;
						
			}
		}
			
		}
		

// --------------------------------------------------------------------Creating Ticket ------------------------------------------------------------------------------------------>>
private void createTicket() {


//	2. Reimbursement Type -->
	System.out.println("Enter the id of Employee who wants to create ticket");
	int employeeId = Integer.parseInt(myScanner.nextLine());
	
	System.out.println("Enter your name? ");
	String empName = myScanner.nextLine();
	
	System.out.println("Enter your locale? ");
	String empLocale = myScanner.nextLine();
	
	System.out.println("Enter your phone");
	int employeePhone = Integer.parseInt(myScanner.nextLine());
	
	
	System.out.println("What type: [L] LODGING \n"
			                     +"[T] TRAVEL  \n"
			                     +"[F] FOOD     \n"
			                     +"[M] MEDICAL  \n"
			                     +"[O] OTHER    \n");
	String userInput = myScanner.nextLine(); //---> Getting the userInput
	Reimbursement type = null;
	switch(userInput) {
	case "L":
		type=Reimbursement.valueOf("LODGING");
		break;
		
	case "T":
		type=Reimbursement.valueOf("TRAVEL");
		break;
		
	case "F":
		type=Reimbursement.valueOf("FOOD");
		break;
		
	case "M":
		type=Reimbursement.valueOf("MEDICAL");
		break;
		
	case "O":
		type=Reimbursement.valueOf("OTHER");
		break;

	default:
		System.out.println("Sorry Wrong Input Please try Again");
		break;
	}
//		3. Transaction amount --->
		System.out.println("Please Enter the Transaction Amount");
		String userAmount = myScanner.nextLine();
		int transAmount = Integer.valueOf(userAmount);
		
		Employee myEmployee = new Employee(empName,empLocale,employeePhone);
		employeeBL.addEmployee(myEmployee);	
		
		RefundTicket myTicket = new RefundTicket(transAmount,type);
		myTicket.setEmployeeId(employeeId);
		myTicket.setTimeStamp(Instant.now());
		ticketBL.addTicket(myTicket);
		
		System.out.println(myTicket);
		
}

		

//------------------------------------------------------------View Tickets--------------------------------------------------------------->>

private void viewTicketById() throws Exception {
	System.out.println("Select ticket By ID:");
	
	for(RefundTicket oneTicket:ticketBL.getTickets()) {
		System.out.println(oneTicket);
	}
	int select = Integer.parseInt(myScanner.nextLine());
	RefundTicket selectedTicket;
	try {
		selectedTicket = ticketBL.getTicketById(select);
		System.out.println(selectedTicket);
	}catch(Exception e) {
		e.printStackTrace();
	}
}



//------------------------------------------------------------View Specific Ticket ------------------------------------------------------->>

private void viewAllEmpTicket(){
	System.out.println("Enter employee ID");
	int select = Integer.parseInt(myScanner.nextLine());
	
	try {
//			Employee emply = employeeBL.getEmployeeById(select);
//			int emplId = emply.getEmployeeId();
			for(RefundTicket oneTicket:ticketBL.getTickets()) {
				if(oneTicket.getEmployeeId()==select) {
					System.out.println(oneTicket);
				}
			}
	}catch(Exception e) {
		e.printStackTrace();
	}

	
	
//	System.out.println("Enter the id of the Employee you'd like to view the ticket for: ");
//	int myEmpID = Integer.parseInt(myScanner.nextLine());
//	Employee foundEmployee = employeeBL.getEmployeeById(myEmpID);
//	System.out.println(foundEmployee);
//	for(RefundTicket oneTicket:foundEmployee.getTickets()) {
//		System.out.println(oneTicket);
//	}
//	RefundTicket myTicket = ticketBL.getTicketById(myTicketId);
//	System.out.println(myTicket);
}


	
	

//-----------------------------------------------------------Updating the ticket------------------------------------------------------------
private void updateTicket() {
//	// TODO Auto-generated method stub
	System.out.println("Please Enter ticketId: ");
	int getTicketId = Integer.parseInt(myScanner.nextLine());
	
	RefundTicket selectedTicket;
	try {
		selectedTicket = ticketBL.getTicketById(getTicketId);
		System.out.println("Update Status: "
						+ "[A] Accept"
						+ "[R] Rejected"
						+ "[X] Exit");
		String userInput = myScanner.nextLine().toLowerCase();
		switch(userInput) {
		case "a":
			selectedTicket.setRefundStatus(Status.APPROVED);
			ticketBL.updateTicket(selectedTicket);
			System.out.println("Ticket Approved");
			break;
			
		case "r":
			selectedTicket.setRefundStatus(Status.REJECTED);
			ticketBL.updateTicket(selectedTicket);
			System.out.println("Ticket Rejected");
			break;
			
		case "x":
			System.out.println("Main Menu");
			
		default:
			break;
		}
	}catch(NumberFormatException ex) {
		System.out.println("Numerics only");
		
	}
}



}
		
		

	
	

