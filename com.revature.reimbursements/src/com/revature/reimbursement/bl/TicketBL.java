package com.revature.reimbursement.bl;

import java.util.List;

import com.revature.reimbursement.dl.IRepository;
import com.revature.reimbursements.models.Ticket;

public class TicketBL implements ITicketBL {
	
	private IRepository repo;
	
	public TicketBL(IRepository repo ) {
		this.repo = repo;
	}

	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		repo.addTicket(ticket);
	}

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return repo.getTickets();
	}

	@Override
	public Ticket getTicketById(int id) throws Exception {
		// TODO Auto-generated method stub
		return repo.getTicketById(id);
	}

}


