package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.Customer;
import com.springmvc.dto.Transaction;

public interface CustomerService {
	
	public void addCustomer(Customer customer);
	
	public String deposit(String cmobno, double cbal);
	
	public String withdraw(String cmobno, double cbal);
	
	public String checkBalance(String cmobno);
	
	public String tfy(String cmobno, String rno, double cbal);
	
	public List<Transaction> displayTransactions();

}
