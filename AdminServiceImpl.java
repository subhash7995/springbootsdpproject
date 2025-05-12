package com.klef.fsd.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.sdp.model.Admin;
import com.klef.fsd.sdp.model.Customer;
import com.klef.fsd.sdp.model.Manager;
import com.klef.fsd.sdp.repository.AdminRepository;
import com.klef.fsd.sdp.repository.CustomerRepository;
import com.klef.fsd.sdp.repository.ManagerRepository;
import com.klef.fsd.sdp.repository.ServiceRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
    private AdminRepository adminRepository;
	
	@Autowired
    private ManagerRepository managerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public Admin checkadminlogin(String username, String password) 
	{
		return adminRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String addmanager(Manager manager) 
	{
		managerRepository.save(manager);
		return "Manager Added Successfully";
	}

	@Override
	public List<Manager> displaymanagers() 
	{
		return managerRepository.findAll();
	}
	
	@Override
	public String deletemanager(int mid)
	{
		 Optional<Manager> manager = managerRepository.findById(mid);
		 if (manager.isPresent())
		 {
			 managerRepository.deleteById(mid);
			 return "Manager Deleted Successfully";
		 }
		 else
		 {
			 return "Manager Id Not Found";
		 }
	}

	@Override
	public List<Customer> displaycustomers() 
	{
		return customerRepository.findAll();
	}

	@Override
	public String deletecustomer(int cid) 
	{
	    Optional<Customer> customer = customerRepository.findById(cid);
	    
	    if (customer.isPresent()) 
	    {	
	        customerRepository.deleteById(cid);
	        return "Customer Deleted Successfully";
	    } 
	    else 
	    {
	        return "Customer ID Not Found";
	    }
	}

	
	@Override
	public long displaycustomercount() 
	{
		return customerRepository.count();
	}

	@Override
	public long displaymanagercount() 
	{
		return managerRepository.count();
	}

	@Override
	public long displayservicecount() 
	{
		return serviceRepository.count();
	}
	
	

}
