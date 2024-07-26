package com.technix.bbplus.service;


import com.technix.bbplus.entity.CustomerOrder;


import java.util.List;

public interface CustomerOrderService {

     CustomerOrder createcustomerorder(CustomerOrder customerOrder);
     List<CustomerOrder> getAllcustomerorder();
     void deletecustomerorder(int id);
     CustomerOrder updatecustomer(int id, CustomerOrder customerorder);

     CustomerOrder getCostomerorderByid(int id);




    List<CustomerOrder> getBycustomerid(int CustomerId );



}
