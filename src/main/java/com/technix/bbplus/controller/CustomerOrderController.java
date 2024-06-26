package com.technix.bbplus.controller;

import com.technix.bbplus.entity.CustomerOrder;
import com.technix.bbplus.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerorder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;
@PostMapping("/post")
    public ResponseEntity<CustomerOrder> createcustomerorder(@RequestBody CustomerOrder customerOrder){

        return new ResponseEntity<CustomerOrder>(customerOrderService.createcustomerorder(customerOrder), HttpStatus.CREATED);
    }
@GetMapping("/get")
    public ResponseEntity<List<CustomerOrder>> getAllcustomrt(){

    return new ResponseEntity<List<CustomerOrder>>(customerOrderService.getAllcustomerorder(),HttpStatus.OK);
    }

@DeleteMapping("/deleteby/{id}")
    public ResponseEntity<String>deletecustomerorder(@PathVariable int id){
    customerOrderService.deletecustomerorder(id);
    return new ResponseEntity<String>("delete sucessfully",HttpStatus.OK);
    }
@PutMapping("/updateby/{id}")
    public ResponseEntity<CustomerOrder>updatecustomer(@PathVariable int id, @RequestBody CustomerOrder customerorder){
    return new ResponseEntity<CustomerOrder>(customerOrderService.updatecustomer(id,customerorder),HttpStatus.CREATED);
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<CustomerOrder>getcustomerorderbyId(@PathVariable int id){
        return new ResponseEntity<>(customerOrderService.getCostomerorderByid(id),HttpStatus.OK);

    }
@GetMapping("/customer/{customerid}")
public ResponseEntity<?>getBycustomerid(int CustomerId){
    return new ResponseEntity<>(customerOrderService.getBycustomerid(CustomerId),HttpStatus.OK);
}


}
