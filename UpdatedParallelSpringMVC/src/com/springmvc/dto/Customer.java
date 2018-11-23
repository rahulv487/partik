package com.springmvc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "My_Bank")
public class Customer {

	@Column(name = "Name")
	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp = "[A-Za-z ]{3,25}", message = "Name must contain only alphabets and must be between 3 and 25 characters")
	String cname;

	@Column(name = "Age")
	@Min(value = 18, message = "Minimum age to open a account is 18")
	@Max(value = 100, message = "Maximum age to open a account is 100")
	@NotNull(message = "Age cannot be empty")
	Integer cage;

	@Column(name = "MobileNo")
	@NotEmpty(message = "Mobile No. cannot be empty")
	@Pattern(regexp = "[6789][0-9]{9}", message = "Mobile No. must be a valid number starting with (6-9) of 10 digits")
	@Id
	String cmobno;

	@Column(name = "Balance")
	@Min(value = 1, message = "Amount must not be 0 or negative")
	@NotNull(message = "Amount cannot be empty")
	Double cbal;

	public Customer() {

	}

	public Customer(String cname, Integer cage, String cmobno, Double cbal) {
		super();
		this.cname = cname;
		this.cage = cage;
		this.cmobno = cmobno;
		this.cbal = cbal;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCage() {
		return cage;
	}

	public void setCage(Integer cage) {
		this.cage = cage;
	}

	public String getCmobno() {
		return cmobno;
	}

	public void setCmobno(String cmobno) {
		this.cmobno = cmobno;
	}

	public Double getCbal() {
		return cbal;
	}

	public void setCbal(Double cbal) {
		this.cbal = cbal;
	}

}
