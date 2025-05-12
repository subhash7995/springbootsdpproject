package com.klef.fsd.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsd.sdp.model.Service;
import com.klef.fsd.sdp.model.Manager;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>
{
	public List<Service> findByManager(Manager manager);
	
	 @Query("select count(e) from Service e")
	 public long servicecount();
}
