package com.revature.reimbursement.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.models.RefundTicket;
import com.revature.reimbursements.models.Ticket;

/**
 * @author dutTech
 * This interface for the data layer 
 * 1.) This class wont be instantiated 
 * 2.) Write the Abstract method --- Just the body of the method  
 */

public interface IRepository {
	void addTicket(RefundTicket newTicket); // method to add the ticket
	List<RefundTicket>getTickets();         // method to get all the tickets
	RefundTicket getTicketById(int id);     // method to retrieve ticket by id     // method to set the ticket by id
	RefundTicket ticket2Update(int id);
}
