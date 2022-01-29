package com.revature.reimbursements.ui;

import java.util.Scanner;

import com.revature.reimbursement.bl.IEmployeeBL;
import com.revature.reimbursement.bl.ITicketBL;
import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

//	Class to present UI to end Users to interact with program
public class MainMenu {
	
//	fields->
	private Scanner myScanner;
	private ITicketBL ticketBL;
	private IEmployeeBL employeeBL;
	private  int ticketId;
	
//	Constructor->

	public MainMenu(Scanner myScanner,ITicketBL ticketBL,IEmployeeBL employeeBL) {
		this.myScanner=myScanner;
		this.ticketBL = ticketBL;
		this.employeeBL=employeeBL;
	}
	
//	public MainMenu(Scanner myScanner,ITicketBL ticketBL) {
//		this(myScanner,ticketBL);
//		this.ticketId = ticketId;
//	}

	
//	Methods->
	public void start() throws Exception {
		
		//Setting a boolean variable to true		
		boolean isDone = true;
		//while its true
		while(isDone) {
			
			//Query the user input
			//Showing all the options on the console by System.out.println 			
			System.out.println("How would you like to interact with the reimburse tickets \n "
					           + "[1] Create ticket \n "
					           + "[2] View Specific ticket \n "
					           + "[3] View all tickets \n "
					           + "[4] Update ticket status"
					           + "[x] Exit");
			
			//Asking the user for the input via console using "scanner.nextline()"
			String myOption = myScanner.nextLine();
			
			switch(myOption) {
				case "1":
					System.out.println("Creating ticket....");
					createTicket();  //----> Calling the createTicket method.
					break;
				case "2":
					System.out.println("View specific ticket.....");
					viewOneTicket(ticketId);
					break;
				case "3":
					System.out.println("Viewing all tickets");
					viewTicket();
					break;
				case "4":
					System.out.println("Updating ticket ....");
//					updateTicket(ticketId);
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
		ticketBL.addTicket(myTicket);
		System.out.println(myTicket);
		
}

		

//------------------------------------------------------------View Tickets--------------------------------------------------------------->>

private void viewTicket() {
	for(RefundTicket oneTicket:ticketBL.getTickets()) {
		System.out.println(oneTicket);
	}
}

//------------------------------------------------------------View Specific Ticket ------------------------------------------------------->>

private void viewOneTicket(int ticketId){
	System.out.println("Enter the id of the Employee you'd like to view the ticket for: ");
	int myTicketId = Integer.parseInt(myScanner.nextLine());
	RefundTicket myTicket = ticketBL.getTicketById(myTicketId);
	System.out.println(myTicket);
}
	
	

//-----------------------------------------------------------Updating the ticket------------------------------------------------------------
//private void updateTicket(int ticketId2) {
//	// TODO Auto-generated method stub
//	System.out.println("Please Enter your EmployeeId: \n");
//	int myEmployeeId = Integer.parseInt(myScanner.nextLine());
//	Ticket updatedTicket = ticketBL.updateTicket(myEmployeeId);
//	System.out.println(updatedTicket);
//}



}
		
		

	
	

