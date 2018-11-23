package com.springmvc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Transaction_1")
@Entity
public class Transaction {
	
	@Column(name="name")
	String tname;
	
	@Column(name="mobileno")
	String tmobno;
	
	@Column(name="credit")
	String credit;
	
	@Column(name="debit")
	String debit;
	
	@Id
	@Column(name="transid")
	String transid;
	
	@Column(name="balance")
	double balance;
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTmobno() {
		return tmobno;
	}
	public void setTmobno(String tmobno) {
		this.tmobno = tmobno;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getTransid() {
		return transid;
	}
	public void setTransid(String transid) {
		this.transid = transid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Transaction [tname=" + tname + ", tmobno=" + tmobno + ", credit=" + credit + ", debit=" + debit
				+ ", transid=" + transid + ", balance=" + balance + "]";
	}
	
	

}
