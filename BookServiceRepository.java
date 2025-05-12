package com.klef.fsd.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.fsd.sdp.model.BookService;
import com.klef.fsd.sdp.model.Customer;

@Repository
public interface BookServiceRepository extends JpaRepository<BookService, Integer>
{
    // Get bookings for a specific customer
    public List<BookService> findByCustomer(Customer customer);
    
    @Query("SELECT b FROM BookService b WHERE b.service.manager.id = ?1")
    public List<BookService> getbookingsbyManager(int mid);
    
    // Update booking status
    @Modifying
    @Transactional
    @Query("UPDATE BookService b SET b.status = ?1 WHERE b.id = ?2")
    public int updateStatusById(String status, int id);
}
