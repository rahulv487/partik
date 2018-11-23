package com.springmvc.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.Customer;
import com.springmvc.dto.Transaction;
import com.springmvc.service.CustomerService;


@RequestMapping(value = "/")
@Controller
public class CustomerController {
	
	@ExceptionHandler(Exception.class)
    public ModelAndView handleMyException(Exception  exception) {
       ModelAndView mv = new ModelAndView("error");
       mv.addObject("message","This Mobile No. is already registered on our portal. Please try again with other Mobile No.");
       return mv;
            } 

	@Autowired
	CustomerService service;
	

//Display ADD CUSTOMER
	@RequestMapping(value = "addCustomer", method = RequestMethod.GET)
	public String displayAddCustomer(Model model) {

		model.addAttribute("aa", new Customer());
		return "AddCustomer";
	}
// ADD THE CUSTOMER
	@RequestMapping(value = "addData", method = RequestMethod.POST)
	public String addCustomer(@Valid@ModelAttribute("aa") Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			return "AddCustomer";
		}
		service.addCustomer(customer);
		return "AddSuccess";
	}
//DISPLAY DEPOSIT
	@RequestMapping(value = "displayDeposit", method = RequestMethod.GET)
	public String displayDeposit(@ModelAttribute("dd") Customer customer) {
		return "Deposit";
	}
//DEPOSIT THE MONEY
	@RequestMapping(value = "depositMoney", method = RequestMethod.POST)
	public ModelAndView depositMoney(@Valid@ModelAttribute("dd") Customer customer1, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("Deposit");
		}
		String fmsg = service.deposit(customer1.getCmobno(), customer1.getCbal());
		return new ModelAndView("DepositResult","result",fmsg);
	}
//DISPLAY WITHDRAW	
	@RequestMapping(value = "displayWithdraw", method = RequestMethod.GET)
	public String displayWithdraw(@ModelAttribute("ww") Customer customer) {
		return "Withdraw";
	}
//WITHDRAW THE MONEY
	@RequestMapping(value = "withdrawMoney", method = RequestMethod.POST)
	public ModelAndView WithdrawMoney(@Valid@ModelAttribute("ww") Customer customer1, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("Withdraw");
		}
		String fmsg = service.withdraw(customer1.getCmobno(), customer1.getCbal());
		return new ModelAndView("WithdrawResult","result",fmsg);
	}
	
//DISPLAY CHECK BALANCE
	@RequestMapping(value = "displayCB", method = RequestMethod.GET)
	public String displayCB() {
		return "CB";
	}
	
//CHECK BALANCE	
	@RequestMapping(value = "checkBal", method = RequestMethod.POST)
	public ModelAndView checkBalance(@RequestParam("mobno") String mn) {
		String rnoerr;
		Pattern p = Pattern.compile("[6789][0-9]{9}");
		Matcher m = p.matcher(mn);
		if(mn.equals("")) {
			return new ModelAndView("CB","rnomsg","Mobile No. cannot be empty");	
		}
		
		else if (!m.matches()) {
		rnoerr = "Mobile number is invalid. Please enter a valid number starting with (6-9) of 10 digits";
		return new ModelAndView("CB","rnomsg",rnoerr);
		}
		String fmsg = service.checkBalance(mn);
		return new ModelAndView("Balance","bal",fmsg);
		
	}
	
//DISPLAY TRANSFER YOUR FUNDS
	@RequestMapping(value = "displayTFY", method = RequestMethod.GET)
	public String displayTFY(@ModelAttribute("tt") Customer customer) {
		return "TFY";
	}

	
	//TFY
	@RequestMapping(value = "tfy", method = RequestMethod.POST)
	public ModelAndView TFY(@Valid@ModelAttribute("tt") Customer customer1, BindingResult result, @RequestParam("rmobno") String remob) {
		String rnoerr = null;
		Pattern p = Pattern.compile("[6789][0-9]{9}");
		Matcher m = p.matcher(remob);
		
		if(result.hasErrors()) {
			if(remob.equals("")) {
			return new ModelAndView("TFY","rnomsg","Mobile No. cannot be empty");	
			}
			
			else if (!m.matches()) {
			rnoerr = "Mobile number is invalid. Please enter a valid number starting with (6-9) of 10 digits";
			return new ModelAndView("TFY","rnomsg",rnoerr);
			}
			
			return new ModelAndView("TFY","rnomsg",rnoerr);
			
			}
		
		
		else if(!result.hasErrors()) {
			if(remob.equals("")) {
				return new ModelAndView("TFY","rnomsg","Mobile No. cannot be empty");	
			}
			
			else if (!m.matches()) {
			rnoerr = "Mobile number is invalid. Please enter a valid number starting with (6-9) of 10 digits";
			return new ModelAndView("TFY","rnomsg",rnoerr);
			}
			
		    }
			
				String fmsg = service.tfy(customer1.getCmobno(), remob, customer1.getCbal());
				return new ModelAndView("TFYResult","result",fmsg);
				
	}
	
	//PRINT TRANSACTIONS
	
	@RequestMapping(value="displayTrans", method=RequestMethod.GET)
	public ModelAndView displayTransaction() {
		List<Transaction> mylist = service.displayTransactions();
		return new ModelAndView("Transactions","l",mylist);	
		
	}
	
	//EXIT
	/*@RequestMapping(value = "exit", method = RequestMethod.GET)
	public String exit() {
		return "exit";
	}
	*/
	
	
}

				
			
		
	
	
	
	


