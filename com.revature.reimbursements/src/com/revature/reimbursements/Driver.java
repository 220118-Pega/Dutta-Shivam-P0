package com.revature.reimbursements;

import java.util.Scanner;

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.models.Ticket;
import com.revature.reimbursements.ui.MainMenu;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScanner = new Scanner(System.in);
		MainMenu myMenu = new MainMenu(myScanner);  //---> MainMenu myMenu = new MainMenu(new Scanner(System.in))
		
		myMenu.start();

		

	}

}