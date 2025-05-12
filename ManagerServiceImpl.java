package com.klef.fsd.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.sdp.model.BookService;
import com.klef.fsd.sdp.model.Manager;
import com.klef.fsd.sdp.repository.BookServiceRepository;
import com.klef.fsd.sdp.repository.ServiceRepository;
import com.klef.fsd.sdp.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService
{
	@Autowired
    private ManagerRepository managerRepository;
	
	
	@Autowired
    private ServiceRepository serviceRepository;
	
	@Autowired
	private BookServiceRepository bookServiceRepository;
	
	
	@Override
	public Manager checkmanagerlogin(String username, String password) 
	{
		return managerRepository.findByUsernameAndPassword(username, password);
	}
	
	@Override
	public String addservice(com.klef.fsd.sdp.model.Service service)
	{
		serviceRepository.save(service);
		return "Service Added Succesfully";
	}

	@Override
	public Manager getManagerById(int mid) 
	{
	   return managerRepository.findById(mid).get();
	}

	@Override
	public List<com.klef.fsd.sdp.model.Service> viewservicesbymanager(int mid) 
	{
		 Manager manager = managerRepository.findById(mid).orElse(null);
		 return serviceRepository.findByManager(manager);
	}

	@Override
	public List<BookService> getbookingsbyManager(int mid) 
	{
		return bookServiceRepository.getbookingsbyManager(mid);
	}

	@Override
	public String updatebookingstatus(int id, String status) 
	{
		bookServiceRepository.updateStatusById(status,id);
		return "Booking Status Updated Successfully";
	}

	
}

