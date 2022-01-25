package com.revature.reimbursements.ui;

import java.util.Scanner;

import com.revature.reimbursement.bl.ITicketBL;
import com.revature.reimbursement.bl.TicketBL;
import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.models.Ticket;

//	Class to present UI to end Users to interact with program
public class MainMenu {
	
//	fields->
	private Scanner myScanner;
	private TicketBL ticketBL;
	
//	Constructor->

	public MainMenu(Scanner myScanner,TicketBL ticketBL) {
		this.myScanner=myScanner;
		this.ticketBL = ticketBL;
	}
	

	
//	Methods->
	public void start() {
		
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
					
					break;
				case "3":
					System.out.println("Viewing all tickets");
					viewTicket();    //-----> Calling the viewTicket method.
					break;
				case "4":
					System.out.println("Updating ticket ....");
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
//	Getting the Input from user 
//	1. User's employeeId--->
	System.out.println("Please Enter your EmployeeId: \n");
	int myEmployeeId = Integer.parseInt(myScanner.nextLine());

//	2. Reimbursement Type -->
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
		double transAmount = Double.parseDouble(userAmount);
		
//		4. Write Description ---->
		System.out.println("Description (Optional): \n");
		System.out.println("[0] write Description \n"
				         + "[1] Exit");
		String getInput = myScanner.nextLine();
		switch(getInput) {
		case "0":
			System.out.println("Please write the description: ");
			String myDescription = myScanner.nextLine();
//			Creating the Ticket
			Ticket newTicket = new Ticket(myEmployeeId,type,transAmount,myDescription);
			System.out.println(newTicket);
			break;
			
		case "1":
			Ticket newTicket1 = new Ticket(myEmployeeId,type,transAmount);
			System.out.println(newTicket1);
			break;
			
		default:
			System.out.println("You haven't register the values");
		}
		
}

//------------------------------------------------------------View Ticket--------------------------------------------------------------->>

private void viewTicket() {
	for(Ticket oneTicket:ticketBL.getTickets()) {
		System.out.println(oneTicket);
	}
}
		
}
		
		

	
	

