package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.CustomerDAO;
import com.springmvc.dto.Customer;
import com.springmvc.dto.Transaction;

@Service("service")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO dao;

	@Override
	public void addCustomer(Customer customer) {
		
		dao.addCustomer(customer);
		
	}

	@Override
	public String deposit(String cmobno, double cbal) {
		
	String sermsg = dao.deposit(cmobno, cbal);
	return sermsg;
	
		
	}

	@Override
	public String withdraw(String cmobno, double cbal) {
		String sermsg = dao.withdraw(cmobno, cbal);
		return sermsg;
	}
	
	@Override
	public String checkBalance(String cmobno) {
		String sermsg = dao.checkBalance(cmobno);
		return sermsg;
	}

	@Override
	public String tfy(String cmobno, String rno, double cbal) {
		String sermsg = dao.trf(cmobno, rno, cbal);
		return sermsg;
		
	}

	@Override
	public List<Transaction> displayTransactions() {
		return dao.displayTransactions();
	}

	

}
