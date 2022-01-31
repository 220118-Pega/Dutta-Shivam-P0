package com.revature.reimbursement.bl;

import java.util.List;

import com.revature.reimbursements.models.RefundTicket;


public interface ITicketBL {
	
	void addTicket(RefundTicket ticket);
	
	List<RefundTicket> getTickets() throws Exception;
	
	RefundTicket getTicketById(int id);
	
	void updateTicket(RefundTicket ticket);
}
