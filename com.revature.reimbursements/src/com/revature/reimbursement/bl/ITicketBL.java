package com.revature.reimbursement.bl;

import java.util.List;

import com.revature.reimbursements.models.Ticket;

public interface ITicketBL {
	
	void addTicket(Ticket ticket);
	
	List<Ticket>getTickets();
	
	Ticket getTicketById(int id) throws Exception;
}
