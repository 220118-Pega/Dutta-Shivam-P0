package com.revature.reimbursement.bl;

import java.util.List;

import com.revature.reimbursements.models.RefundTicket;
import com.revature.reimbursements.models.Ticket;

public interface ITicketBL {
	
	void addTicket(RefundTicket ticket);
	
	List<RefundTicket> getTickets();
	
	RefundTicket getTicketById(int id) throws Exception;
	
	RefundTicket updateTicket(int id);
}
