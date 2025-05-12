package com.klef.fsd.sdp.service;
import java.util.List;

import com.klef.fsd.sdp.model.BookService;
import com.klef.fsd.sdp.model.Customer;
import com.klef.fsd.sdp.model.Service;

import com.klef.fsd.sdp.model.Customer;

public interface CustomerService 
{
  public String customerregistration(Customer customer);
  public Customer checkcustomerlogin(String username,String password);
  
  public String customerupdateprofile(Customer customer);
  
  public List<Service> viewallservices();
  
  public Customer getCustomerById(int cid);
  public Service getServiceById(int eid);
  
  public String bookservice(BookService bookService);
  public List<BookService> getbookedservicesByCustomer(int cid);


}
