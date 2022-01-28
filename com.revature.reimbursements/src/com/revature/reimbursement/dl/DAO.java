package com.revature.reimbursement.dl;

import java.util.List;

public interface DAO<T,K> {
	T findById(K id);
	List<T>findAll();
	void add(T newObject);
	void update(T newObject);
}
