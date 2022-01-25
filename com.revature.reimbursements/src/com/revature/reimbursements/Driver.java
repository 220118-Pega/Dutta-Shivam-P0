package com.revature.reimbursements;

import java.util.Scanner;

import com.revature.reimbursement.bl.TicketBL;
import com.revature.reimbursement.dl.InMemoryRepo;
import com.revature.reimbursements.ui.MainMenu;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScanner = new Scanner(System.in);
		InMemoryRepo myRepo = new InMemoryRepo();
		TicketBL myTicket = new TicketBL(myRepo);
		MainMenu myMenu = new MainMenu(myScanner,myTicket);  //---> MainMenu myMenu = new MainMenu(new Scanner(System.in))
		
		myMenu.start();

		

	}
}