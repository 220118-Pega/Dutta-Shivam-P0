package com.revature.reimbursement.dl;

import java.util.List;

import com.revature.reimbursements.models.Ticket;

/**
 * @author dutTech
 * This interface for the data layer 
 * 1.) This class wont be instantiated 
 * 2.) Write the Abstract method --- Just the body of the method  
 */

public interface IRepository {
	void addTicket(Ticket newTicket); // method to add the ticket
	List<Ticket>getTickets();         // method to get all the tickets
	Ticket getTicketById(int id) throws Exception;     // method to retrieve ticket by id
	Ticket setTicketById(int id) throws Exception;     // method to set the ticket by id
}
