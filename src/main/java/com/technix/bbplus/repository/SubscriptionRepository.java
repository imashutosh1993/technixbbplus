package com.technix.bbplus.repository;


import com.technix.bbplus.entity.Subscription;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {


    List<Subscription> findBycustomerId(int CustomerId);

}
