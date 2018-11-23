package com.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dto.Customer;
import com.springmvc.dto.Transaction;


@Repository("dao")
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	EntityManager em;
	
	
//ADD CUSTOMER
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		em.persist(customer);
		em.flush();
	}
	
//DEPOSIT
	@Override
	@Transactional
	public String deposit(String cmobno, double cbal) {
		Customer customer = em.find(Customer.class, cmobno);
		if(customer == null) {
		String msg = "You have entered incorrect mobile number. This mobile number is not associated with any account on our portal";
		return msg;
		}
		double amt = customer.getCbal();
		amt = amt + cbal;
		customer.setCbal(amt);
		
		String msg1 = "Your money is successfully deposited into your account. UPDATED BALANCE : "+amt;
		
		
		Transaction t = new Transaction();
		t.setTname(customer.getCname());
		t.setTmobno(customer.getCmobno());
		t.setCredit(String.valueOf(cbal));
		t.setDebit("null");
		t.setTransid(String.valueOf((int)((Math.random())*100000000)));
		t.setBalance(amt);
		em.persist(t);
		em.flush();
		
		
		return msg1;
		
		
	}
	
//WITHDRAW
	@Override
	@Transactional
	public String withdraw(String cmobno, double cbal) {
		Customer customer = em.find(Customer.class, cmobno);
		if(customer == null) {
		String msg = "You have entered incorrect mobile number. This mobile number is not associated with any account on our portal";
		return msg;
		}
		else if(cbal==customer.getCbal()) {
		String msg3 = "You are trying to withdraw all money from your account. Balance cannot be 0. Atleast 1 Rs. should be always in your account";	
		return msg3;
		}
		else if(cbal>customer.getCbal()) {
		String msg1 = "Insufficient funds in your account. You are trying to withdraw more than available balance in your account. Please enter valid amount";
		return msg1;
		}
		double amt = customer.getCbal();
		amt = amt - cbal;
		customer.setCbal(amt);
		String msg2 = "Your money is successfully withdrawn from your account. UPDATED BALANCE : "+amt;
		
		
		Transaction t = new Transaction();
		t.setTname(customer.getCname());
		t.setTmobno(customer.getCmobno());
		t.setCredit("null");
		t.setDebit(String.valueOf(cbal));
		t.setTransid(String.valueOf((int)((Math.random())*100000000)));
		t.setBalance(amt);
		em.persist(t);
		em.flush();
		
		return msg2;	
	}
	
//CHECK BALANCE
	
	@Override
	@Transactional
	public String checkBalance(String cmobno) {
		Customer cust = em.find(Customer.class, cmobno);
		if(cust == null) {
		return "You have entered incorrect mobile number. This mobile number is not associated with any account on our portal";
		}
		double bal = cust.getCbal();
		return "Balance for "+cmobno+" is : "+bal;
		
	}
	
	//TRANSFER YOUR FUNDS
	@Override
	@Transactional
	public String trf(String cmobno, String rno, double cbal) {
		//DEBIT
		Customer customer = em.find(Customer.class, cmobno);
		Customer customerR = em.find(Customer.class, rno);
		if(customer == null) {
			String msg = "You have entered incorrect mobile number. This SENDER mobile number is not associated with any account on our portal";
			return msg;
			}
		else if(customerR == null) {
			String msgR = "You have entered incorrect mobile number. This RECEIVER mobile number is not associated with any account on our portal";
			return msgR;	
		}
		
		else if(customer.getCmobno().equals(customerR.getCmobno())) {
			String msg = "Transfer Failed. Sender Mobile No. and Receiver Mobile No. cannot be same";
			return msg;
		}
			
			else if(cbal==customer.getCbal()) {
			String msg3 = "You are trying to send all money from your account. Balance cannot be 0. Atleast 1 Rs. should be always in your account";	
			return msg3;
			}
			else if(cbal>customer.getCbal()) {
			String msg1 = "Insufficient funds in your account. You are trying to send more than available balance in your account. Please enter valid amount";
			return msg1;
			}
			double amt = customer.getCbal();
			amt = amt - cbal;
			customer.setCbal(amt);
			
			
			Transaction t = new Transaction();
			t.setTname(customer.getCname());
			t.setTmobno(customer.getCmobno());
			t.setCredit("null");
			t.setDebit(String.valueOf(cbal));
			t.setTransid(String.valueOf((int)((Math.random())*100000000)));
			t.setBalance(amt);
			em.persist(t);
			em.flush();
			
			
			
//CREDIT			
			
				double amtR = customerR.getCbal();
				amtR = amtR + cbal;
				customerR.setCbal(amtR);
				
				
				Transaction t1 = new Transaction();
				t1.setTname(customerR.getCname());
				t1.setTmobno(customerR.getCmobno());
				t1.setCredit(String.valueOf(cbal));
				t1.setDebit("null");
				t1.setTransid(String.valueOf((int)((Math.random())*100000000)));
				t1.setBalance(amtR);
				em.persist(t1);
				em.flush();
				
				
//SUCCESS MSG FOR SENDER			
				
			String msg2 = "Your money is successfully transferred to "+rno+"   UPDATED BALANCE : "+amt;
			return msg2;	
			
	}

	
//PRINT TRANSACTIONS
	
	@Override
	@Transactional
	public List<Transaction> displayTransactions() {
		Query query = em.createQuery("Select t from Transaction t");
		@SuppressWarnings("unchecked")
		List<Transaction> list = query.getResultList();
		System.out.println(list);
		return list;
	
	}

	
	


}
