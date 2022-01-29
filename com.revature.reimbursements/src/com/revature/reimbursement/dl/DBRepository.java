package com.revature.reimbursement.dl;

import java.util.List;

import com.revature.reimbursements.models.Employee;
import com.revature.reimbursements.models.RefundTicket;

public class DBRepository implements IRepository{
	private DAO<RefundTicket,Integer> ticketDAO;
	private DAO<Employee,Integer> employeeDAO;
	
	public DBRepository(DAO<RefundTicket,Integer> ticketDAO,
						DAO<Employee,Integer> employeeDAO) {
		this.ticketDAO=ticketDAO;
		this.employeeDAO=employeeDAO;
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
		return ticketDAO.findById(id);
	}

	@Override
	public RefundTicket ticket2Update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.add(newEmployee);
	}

}
