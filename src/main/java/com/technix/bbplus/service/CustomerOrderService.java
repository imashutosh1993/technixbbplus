package com.technix.bbplus.service;

import com.technix.bbplus.entity.Company;
import com.technix.bbplus.entity.CustomerOrder;
import com.technix.bbplus.entity.User;

import java.util.List;

public interface CustomerOrderService {

     CustomerOrder createcustomerorder(CustomerOrder customerOrder);
     List<CustomerOrder> getAllcustomerorder();
     void deletecustomerorder(int id);
     CustomerOrder updatecustomer(int id, CustomerOrder customerorder);

     CustomerOrder getCostomerorderByid(int id);




    List<CustomerOrder> getBycustomerid(int CustomerId );



}
