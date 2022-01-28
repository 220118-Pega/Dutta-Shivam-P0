package com.revature.reimbursement.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.Ticket;


//public class InMemoryRepo implements IRepository{
	
	//Fields -->
//	private static ArrayList<Ticket> listOfTickets = new ArrayList<Ticket>();
//	private static int latestId;
//	private Status status;
	//Constructor
//	public InMemoryRepo() {
//		Ticket myTicket = new Ticket(7,Reimbursement.TRAVEL,70.0);
//		Ticket myTicket2 = new Ticket(5,Reimbursement.FOOD,89.9);
//		listOfTickets.add(myTicket);
//		listOfTickets.add(myTicket2);
		
//		System.out.println( "myNewTicket is: "+myNewTicket);
//	}
//	
//	@Override
//	public void addTicket(Ticket newTicket) {
		// TODO Auto-generated method stub
//		newTicket.setId(latestId);
//		listOfTickets.add(newTicket);
		
//	}

//	@Override
//	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
//		if(listOfTickets == null) {
//			System.out.println("its null");
//		}
//			return listOfTickets;
//	}

//	@Override
//	public Ticket getTicketById(int id) {
//		Ticket foundTicket = null;
		// TODO Auto-generated method stub
//		for(Ticket oneTicket:listOfTickets) {
//			if(oneTicket.getEmployeeId()==id) {
//				 foundTicket= oneTicket;
//			}else if(foundTicket == null) {
//				System.out.println("Ticket not found");
//			}
//		}
//		return foundTicket;
//	}
	
//	@Override
//	public Ticket setTicketById(int id) throws Exception{
		// TODO Auto-generated method stub
//		Ticket updatedTicket = getTicketById(id);
//		
//		return updatedTicket;
//	}

//	@Override
//	public Ticket ticket2Update(int id) {
//		Ticket foundTicket =null;
//		try {
//			for(Ticket oneTicket:listOfTickets) {
//				if(oneTicket.getEmployeeId()==id) {
//					foundTicket.setStatus(status.APPROVED);
//					listOfTickets.add(foundTicket);
//					System.out.println("foundTicket is:"+ foundTicket.toString());
//					
//				}else {
//					try {
//						
//						foundTicket.getStatus();
//					}catch(IllegalStateException ex) {
//						System.out.println("Exited from terminal");
//					}
//				}
//			}
//		}
//			
//		catch(NullPointerException e) {
//			System.out.println("This ticket doesnot exsist");
//		}
//		return foundTicket;
//		}
//	}

