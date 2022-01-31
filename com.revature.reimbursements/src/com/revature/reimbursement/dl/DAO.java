package com.revature.reimbursement.dl;

import java.util.List;

import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.RefundTicket;

public interface DAO<T,K> {
	T findById(K id);
	List<T>findAll() throws Exception;
	List<RefundTicket> filterStatus(Status status);
	void add(T newObject);
	void update(T newObject);
}
