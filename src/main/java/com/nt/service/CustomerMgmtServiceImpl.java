package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Service("customerService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;
	
	@Override
	public String registerCustomer(Customer customer) {
		System.out.println("Cust Id before Saved::"+customer.getCno());
		Customer cust = custRepo.save(customer);
		return "Customer obj is saved with id value::"+cust.getCno();
	}

	@Override
	public String registerGroupOfCustomer(Iterable<Customer> customers) {
		if(customers!=null) {
			Iterable<Customer> saveCustomers = custRepo.saveAll(customers);
			int size = ((Collection) saveCustomers).size();
			List<Integer> ids = (List<Integer>)((Collection)saveCustomers).stream().map(c->((Customer)c).getCno()).collect(Collectors.toList());
			return size+"no of  customer are saved with id values::"+ids.toString();
		}
		else 
			throw new IllegalArgumentException("Invalid Customers Info::");
	}

	@Override
	public boolean isCustomerAvailable(Integer id) {
		//use repo
		boolean  flag = custRepo.existsById(id);
		return flag;
	}

	@Override
	public long fetchCustomerCount() {
		return custRepo.count();
	}

	@Override
	public boolean checkCustomerAvailbility(Integer id) {
		return custRepo.existsById(id);
	}

	@Override
	public Iterable<Customer> showAllCustomers() {
		return custRepo.findAll();
	}

	@Override
	public Iterable<Customer> showAllCustomerById(Iterable<Integer> ids) {
		return custRepo.findAllById(ids);
	}

	@Override
	public Customer showCustomerByid(Integer id) {
		Customer customer = custRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Customer Id::"));
		return customer;
	}

	@Override
	public String updateCustomerBillAmtById(Integer id, float hikePercentage) {
		//load object
		Optional<Customer> opt = custRepo.findById(id);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			float newBillAmt = customer.getBillAmt()+(customer.getBillAmt()*(hikePercentage/100.0f));
			//set the new income to the entity object
			customer.setBillAmt(newBillAmt);
			//partially updated the object
			return custRepo.save(customer).getCno()+"Is Updated With::"+newBillAmt;
		}
		else {
			return id+"Doctor Not Found For Updatetation.....";
	}	
}
}
