package com.nt.service;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {

	public String registerCustomer(Customer customer);
	public String registerGroupOfCustomer(Iterable<Customer> customers);
	public boolean isCustomerAvailable(Integer id);
	public long  fetchCustomerCount();
	public boolean checkCustomerAvailbility(Integer id);
	public Iterable<Customer> showAllCustomers();
	public Iterable<Customer> showAllCustomerById(Iterable<Integer> ids);
	public Customer showCustomerByid(Integer id);
	public String  updateCustomerBillAmtById(Integer id,float hikePercentage);

}

