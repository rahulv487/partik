package com.springmvc.dao;

import java.util.List;

import com.springmvc.dto.Customer;
import com.springmvc.dto.Transaction;


public interface CustomerDAO {

	public void addCustomer(Customer customer);
	
	public String deposit(String cmobno, double cbal);
	
	public String withdraw(String cmobno, double cbal);
	
	public String checkBalance(String cmobno);
	
	public String trf(String cmobno, String rno, double cbal);
	
	public List<Transaction> displayTransactions();
}
