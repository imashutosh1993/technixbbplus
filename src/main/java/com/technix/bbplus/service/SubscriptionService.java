package com.technix.bbplus.service;
import com.technix.bbplus.entity.Subscription;
import com.technix.bbplus.entity.User;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
     List<Subscription> getAllSubscriptions();
     Optional<Subscription> getSubscriptionById(int subsId);
     Subscription createSubscription(Subscription subscription);
     Subscription updateSubscription(int subsId, Subscription subscription);
     void deleteSubscription(int subsId);

     List<Subscription> getBycustomerId(int CustomerId );


}
