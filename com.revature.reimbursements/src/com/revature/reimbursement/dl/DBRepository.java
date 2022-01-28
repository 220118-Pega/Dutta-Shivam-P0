package com.revature.reimbursement.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.models.RefundTicket;

public class DBRepository implements IRepository{
	private DAO<RefundTicket,Integer> ticketDAO;
	
	public DBRepository(DAO<RefundTicket,Integer> ticketDAO) {
		this.ticketDAO=ticketDAO;
	}

	@Override
	public void addTicket(RefundTicket newTicket) {
		// TODO Auto-generated method stub
		ticketDAO.add(newTicket);
		
	}

	@Override
	public List<RefundTicket> getTickets() {
		// TODO Auto-generated method stub
		return ticketDAO.findAll();
	}

	@Override
	public RefundTicket getTicketById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefundTicket ticket2Update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
