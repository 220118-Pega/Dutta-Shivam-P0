package com.revature.reimbursement.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.models.Ticket;


public class InMemoryRepo implements IRepository{
	
	//Fields -->
	private static ArrayList<Ticket> listOfTickets;
	private static int latestId;
	
	//Constructor
	public InMemoryRepo() {
		ArrayList<Ticket> myNewTicket = new ArrayList<Ticket>();
		Ticket myTicket = new Ticket(7,Reimbursement.TRAVEL,70.0);
		myNewTicket.add(myTicket);
		System.out.println(myNewTicket);
	}
	
	@Override
	public void addTicket(Ticket newTicket) {
		// TODO Auto-generated method stub
		newTicket.setId(latestId);
		listOfTickets.add(newTicket);
		latestId++;
	}

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return listOfTickets;
	}

//	@Override
//	public Ticket getTicketById(int id) {
//		Ticket foundTicket = null;
//		// TODO Auto-generated method stub
//		for(Ticket oneTicket:listOfTickets) {
//			if(oneTicket.getId()==id) {
//				 foundTicket= oneTicket;
//			}else if(foundTicket == null) {
//				System.out.println("Ticket not found");
//			}
//		}
//		return foundTicket;
//	}
	
	@Override
	public Ticket getTicketById(int id) throws Exception {
		// TODO Auto-generated method stub
		Ticket foundTicket = null;
		for(Ticket ticket: listOfTickets) {
			if(ticket.getId() == id) {
				foundTicket = ticket;
			}
		}
		if(foundTicket == null) throw new Exception("Ticket not found");
		return foundTicket;
	}

	@Override
	public Ticket setTicketById(int id) throws Exception{
		// TODO Auto-generated method stub
		Ticket updatedTicket = getTicketById(id);
		
		return updatedTicket;
	}

}
