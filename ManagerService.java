package com.klef.fsd.sdp.service;

import java.util.List;

import com.klef.fsd.sdp.model.BookService;
import com.klef.fsd.sdp.model.Manager;
import com.klef.fsd.sdp.model.Service;

public interface ManagerService 
{
  public Manager checkmanagerlogin(String username,String password);
  
  public String addservice(Service service);
  public List<Service> viewservicesbymanager(int mid);
  
  public Manager getManagerById(int mid);

 public List<BookService> getbookingsbyManager(int mid);
  
  public String updatebookingstatus(int id,String status);
    
  
}
