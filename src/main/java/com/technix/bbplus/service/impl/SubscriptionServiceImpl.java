package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.Subscription;
import com.technix.bbplus.repository.CustomerRepository;
import com.technix.bbplus.repository.SubscriptionRepository;
import com.technix.bbplus.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> getSubscriptionById(int subsId) {
        return subscriptionRepository.findById(subsId);
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }


    @Override
    public Subscription updateSubscription(int subsId, Subscription subscription) {
        return subscriptionRepository.findById(subsId).map(existingSubscription -> {
            if (subscription.getPlanId() != 0) existingSubscription.setPlanId(subscription.getPlanId());
            if (subscription.getPlanValidity() != 0)
                existingSubscription.setPlanValidity(subscription.getPlanValidity());
            if (subscription.getPlanStart() != null) existingSubscription.setPlanStart(subscription.getPlanStart());
            if (subscription.getPlanEnd() != null) existingSubscription.setPlanEnd(subscription.getPlanEnd());
            if (subscription.getStatus() != 0) existingSubscription.setStatus(subscription.getStatus());
            if (subscription.getCreatedBy() != 0) existingSubscription.setCreatedBy(subscription.getCreatedBy());
            if (subscription.getCreatedAt() != null) existingSubscription.setCreatedAt(subscription.getCreatedAt());
            return subscriptionRepository.save(existingSubscription);
        }).orElseThrow(() -> new RuntimeException("Subscription not found with id " + subsId));
    }

    @Override
    public void deleteSubscription(int subsId) {
        subscriptionRepository.deleteById(subsId);
    }

    @Override
    public List<Subscription> getBycustomerId(int CustomerId) {
        return subscriptionRepository.findBycustomerId(CustomerId);
    }


}
