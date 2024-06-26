package com.technix.bbplus.controller;
import com.technix.bbplus.entity.Customer;
import com.technix.bbplus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/post")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = customerService.createCustomer(customer);
            return ResponseEntity.ok(createdCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }
    }
    @GetMapping("/getby/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
        }

    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteCompany(@PathVariable int id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("delete sucessfully",HttpStatus.OK);





    }




}
