package com.technix.bbplus.repository;

import com.technix.bbplus.entity.CustomerOrder;
import com.technix.bbplus.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {


    List<CustomerOrder> findBycustomerId(int CustomerId);



}

