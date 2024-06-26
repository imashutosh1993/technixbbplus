package com.technix.bbplus.service;
import com.technix.bbplus.entity.Customer;
import java.util.List;
public interface CustomerService {

     Customer createCustomer(Customer customer);
     Customer getCustomerById(int id);
     List<Customer> getAllCustomers();
     Customer updateCustomer(int id, Customer customer);
     Customer deleteCustomer(int id);

}
