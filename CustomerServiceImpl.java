package com.klef.fsd.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.klef.fsd.sdp.model.BookService;
import com.klef.fsd.sdp.model.Customer;
import com.klef.fsd.sdp.model.Service;

import com.klef.fsd.sdp.repository.BookServiceRepository;
import com.klef.fsd.sdp.repository.CustomerRepository;
import com.klef.fsd.sdp.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private BookServiceRepository bookServiceRepository;
	
	@Override
	public String customerregistration(Customer customer) 
	{
		customerRepository.save(customer);
		return "Customer Registered Successfully";
	}

	@Override
	public Customer checkcustomerlogin(String username, String password) 
	{
		return customerRepository.findByUsernameAndPassword(username, password);
	}
	
	@Override
	public String customerupdateprofile(Customer customer) 
	{
		Optional<Customer> object	= customerRepository.findById(customer.getId());
		
		String msg = null;
			  
			  if(object.isPresent())
			  {
				  Customer c = object.get();
				  
				  c.setName(customer.getName());
				  c.setDob(customer.getDob());
				  c.setMobileno(customer.getMobileno());
				  c.setEmail(customer.getEmail());
				  c.setPassword(customer.getPassword());
				  c.setLocation(customer.getLocation());
				  
				  customerRepository.save(customer);
				  
				  msg = "Customer Profile Updated Successfully";
			  }
			  else
			  {
				  msg = "Customer ID Not Found to Update";
			  }
			  return msg;
	}

	@Override
	public List<com.klef.fsd.sdp.model.Service> viewallservices() 
	{
	   return serviceRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int cid) 
	{
		return customerRepository.findById(cid).orElse(null);
	}

	@Override
	public com.klef.fsd.sdp.model.Service getServiceById(int eid) 
	{
		return serviceRepository.findById(eid).orElse(null);
	}

	@Override
	public String bookservice(BookService bookService) 
	{
		bookServiceRepository.save(bookService);
		return "Service Booked Successfully";
	}

	@Override
	public List<BookService> getbookedservicesByCustomer(int cid) 
	{
		Customer customer = customerRepository.findById(cid).orElse(null);
		return bookServiceRepository.findByCustomer(customer);
	}


}
