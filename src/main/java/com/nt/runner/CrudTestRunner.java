package com.nt.runner;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class CrudTestRunner implements CommandLineRunner{

	@Autowired
	private ICustomerMgmtService custService;
	
	@Override
	public void run(String... args) throws Exception {
		/*Customer cust = new Customer();
		cust.setCname("situ");
		cust.setCaddrs("goa");
		cust.setBillAmt(454354.0f);
		String msg = custService.registerCustomer(cust);
		System.out.println(msg);
		
		
		try {
			Customer cust1 = new Customer();
			cust1.setCname("jeevan");
			cust1.setCaddrs("odisha");
			cust1.setBillAmt(654354.0f);
			Customer cust2 = new Customer();
			cust2.setCname("pintu");
			cust2.setCaddrs("pune");
			cust2.setBillAmt(124354.0f);
			Customer cust3 = new Customer();
			cust3.setCname("chintu");
			cust3.setCaddrs("hyd");
			cust3.setBillAmt(654388.0f);
			String msg = custService.registerGroupOfCustomer(List.of(cust1,cust2,cust3));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			boolean  flag = custService.isCustomerAvailable(252);
			if(flag)
				System.out.println("Customer Available......");
			else
				System.out.println("Customer not Available...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Count of  Records::"+custService.fetchCustomerCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("2955 is available:"+custService.checkCustomerAvailbility(295));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			 Iterable<Customer> it = custService.showAllCustomers();
			 it.forEach(cust->{
				 System.out.println(cust);
			 });
			 System.out.println("-------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
	}

		try {
			custService.showAllCustomerById(List.of(2952,3002,41,42,43)).forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Customer cust  = custService.showCustomerByid(41);
			System.out.println(cust);
		}
		catch(Exception e) {
			e.printStackTrace();
		} */
		
		try {
			System.out.println("42 Customer Info::"+custService.showCustomerByid(42));
			System.out.println(custService.updateCustomerBillAmtById(42, 20.0f));
			System.out.println("42 Customer Info::"+custService.showCustomerByid(42));
		}
		catch(Exception e) {
			System.out.println(e.printStackTrace());
		}
		
	}
}
