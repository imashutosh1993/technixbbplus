package com.technix.bbplus.controller;
import com.technix.bbplus.entity.Subscription;
import com.technix.bbplus.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcription")
public class SubscriptionController {


    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/get")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/getbyid/{Id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable int subsId) {
        return subscriptionService.getSubscriptionById(subsId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @PutMapping("/updateby/{subsId}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable int subsId, @RequestBody Subscription subscription) {
        try {
            Subscription updatedSubscription = subscriptionService.updateSubscription(subsId, subscription);
            return ResponseEntity.ok(updatedSubscription);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteby/{Id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable int subsId) {
        subscriptionService.deleteSubscription(subsId);
        return ResponseEntity.noContent().build();
    }
@GetMapping("/customer/{customerId}")
public ResponseEntity<?>getBycustomerId(int CustomerId){
        return new ResponseEntity<>(subscriptionService.getBycustomerId(CustomerId), HttpStatus.OK);

}

}
