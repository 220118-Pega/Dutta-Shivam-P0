package com.revature.reimbursements.ui;

import java.util.Scanner;

import com.revature.reimbursement.bl.ITicketBL;
import com.revature.reimbursement.bl.TicketBL;
import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.models.RefundTicket;
import com.revature.reimbursements.models.Ticket;

//	Class to present UI to end Users to interact with program
public class MainMenu {
	
//	fields->
	private Scanner myScanner;
	private ITicketBL ticketBL;
//	private  int ticketId;
	
//	Constructor->

	public MainMenu(Scanner myScanner,ITicketBL ticketBL) {
		this.myScanner=myScanner;
		this.ticketBL = ticketBL;
	}
	
//	public MainMenu(Scanner myScanner,ITicketBL ticketBL) {
//		this(myScanner,ticketBL);
//		this.ticketId = ticketId;
//	}

	
//	Methods->
	public void start() throws Exception {
		
		//Setting a boolean variable to true		
		boolean isDone = true;
		int found =0;
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
//					viewwOneTicket(ticketId);
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
//					exiting();
//					try {
//						myScanner.close();
//					}catch(IllegalStateException e) {
//						System.out.println("exited");
//					}
					break;
					
					default:
						break;
						
			}
		}
			
		}
		








//private void exiting() throws Exception {
//	// TODO Auto-generated method stub
//	System.out.println("do you want exit?"
//			+ "[0] to exit"
//			+ "[1] to continue");
//	String myInput= myScanner.nextLine();
//	if(myInput.equals("1")) {
//		start();
//	}else {
//		myScanner.close();
//	}
//}

// --------------------------------------------------------------------Creating Ticket ------------------------------------------------------------------------------------------>>
private void createTicket() {
//	Getting the Input from user 
//	1. User's employeeId--->
//	System.out.println("Please Enter your EmployeeId: \n");
//	int myEmployeeId = Integer.parseInt(myScanner.nextLine());

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
		int transAmount = Integer.valueOf(userAmount);
		
		RefundTicket myTicket = new RefundTicket(transAmount,type);
		ticketBL.addTicket(myTicket);
		System.out.println(myTicket);

		
}

//------------------------------------------------------------View Ticket--------------------------------------------------------------->>

private void viewTicket() {
	for(RefundTicket oneTicket:ticketBL.getTickets()) {
		System.out.println(oneTicket.getRefundStatus());
		System.out.println(oneTicket.getTicketId());
	}
}

//------------------------------------------------------------View Specific Ticket ------------------------------------------------------->>

//private void viewOneTicket(int ticketId2) throws Exception {
//	System.out.println("Please enter ticket Id....");
//	int myEmployeeId = Integer.parseInt(myScanner.nextLine());
//	Ticket myTicket = ticketBL.getTicketById(myEmployeeId);
//	System.out.println(myTicket.toString());
//	System.out.println(myTicket.);
//	
//}

//-----------------------------------------------------------Updating the ticket------------------------------------------------------------
//private void updateTicket(int ticketId2) {
//	// TODO Auto-generated method stub
//	System.out.println("Please Enter your EmployeeId: \n");
//	int myEmployeeId = Integer.parseInt(myScanner.nextLine());
//	Ticket updatedTicket = ticketBL.updateTicket(myEmployeeId);
//	System.out.println(updatedTicket);
//}



}
		
		

	
	

