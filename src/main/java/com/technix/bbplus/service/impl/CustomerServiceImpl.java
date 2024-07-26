package com.technix.bbplus.service.impl;
import com.technix.bbplus.entity.Customer;
import com.technix.bbplus.repository.CustomerRepository;
import com.technix.bbplus.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
        public Customer getCustomerById(int id){
        try {
            return customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not found"));
        }catch(Exception e){
            log.error("Resource not found");
            throw new RuntimeException("failed to get customer");
        }
        }

        @Override
        public List<Customer> getAllCustomers() {
            try {
                return customerRepository.findAll();
            }catch (Exception e){
                log.error("Resource not found ");
                throw new RuntimeException("customer not found");
            }
        }

        @Override
        public Customer updateCustomer(int id, Customer customer) {
            try {
                Customer existingCustomer = customerRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Customer not found"));
                if (customer.getCustomerId()!=0){
                    existingCustomer.setCustomerId(customer.getCustomerId());
                }
                if (customer.getEmail()!=null){
                    existingCustomer.setEmail(customer.getEmail());
                }
                if (customer.getPhoneNumber()!=null){
                    existingCustomer.setPhoneNumber(customer.getPhoneNumber());
                }
                if (customer.getCompany()!=null){
                    existingCustomer.setCompany(customer.getCompany());
                }
                if (customer.getCountry()!=null){
                    existingCustomer.setCountry(customer.getCountry());
                }
                if (customer.getFullName()!=null){
                    existingCustomer.setFullName(customer.getFullName());
                }
                return customerRepository.save(existingCustomer);
            } catch (RuntimeException e) {
                log.error("update error");
                throw new RuntimeException("Failed to update customer", e);
            }
        }

        @Override
        public Customer deleteCustomer(int id) {
            try {
                Customer customer = customerRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Customer not found"));
                customerRepository.delete(customer);
            } catch (RuntimeException e) {
                log.error("delete error");
                throw new RuntimeException("customer not available", e);
            }
            return null;
        }


}


