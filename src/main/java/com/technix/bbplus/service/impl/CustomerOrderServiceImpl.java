package com.technix.bbplus.service.impl;
import com.technix.bbplus.entity.Customer;
import com.technix.bbplus.entity.CustomerOrder;
import com.technix.bbplus.repository.CustomerOrderRepository;
import com.technix.bbplus.repository.CustomerRepository;
import com.technix.bbplus.service.CustomerOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerorderRepo;
    @Autowired
private CustomerRepository customerRepository;
    @Override
    public CustomerOrder createcustomerorder(CustomerOrder customerOrder) {
      return customerorderRepo.save(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAllcustomerorder() {
        return customerorderRepo.findAll();
    }

    @Override
    public void deletecustomerorder(int id) {
        try {
            CustomerOrder customerorder = customerorderRepo.findById(id)
                    .orElseThrow(() -> new Exception("customer order  Not fond"));
            customerorderRepo.delete(customerorder);
        } catch (Exception e) {
            log.error("delete error");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CustomerOrder updatecustomer(int id, CustomerOrder customerorder) {
        try {

            CustomerOrder existingcustomerorder = customerorderRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("customer order not found"));
            CustomerOrder customerorder1 = existingcustomerorder;
            if (customerorder.getOrderId() != null) {
                customerorder1.setOrderId(customerorder.getOrderId());
            }

            if (customerorder.getOrderDate() != null) {
                customerorder1.setOrderDate(customerorder.getOrderDate());
            }
            if (customerorder.getPlanId() != 0) {
                customerorder1.setPlanId(customerorder.getPlanId());
            }

            if (customerorder.getPlanRate() != 0) {
                customerorder1.setPlanRate(customerorder.getPlanRate());
            }
            if (customerorder.getPlanValidity() != 0) {
                customerorder1.setPlanId(customerorder.getPlanId());
            }
            if (customerorder.getPlanValue() != 0) {
                customerorder1.setPlanValue(customerorder.getPlanValue());
            }

            if (customerorder.getPlanValidity() != 0) {
                customerorder1.setPlanValidity(customerorder.getPlanValidity());
            }
            if (customerorder.getSubTotal() != 0) {
                customerorder1.setSubTotal(customerorder.getSubTotal());
            }
            if (customerorder.getDiscount() != 0) {
                customerorder1.setSubTotal(customerorder.getSubTotal());
            }
            if (customerorder.getDiscount() != 0) {
                customerorder1.setDiscount(customerorder.getDiscount());
            }
            if (customerorder.getTotalAmount() != 0) {
                customerorder1.setTotalAmount(customerorder.getTotalAmount());
            }
            if (customerorder.getTexableValue() != 0) {
                customerorder1.setTexableValue(customerorder.getTexableValue());
            }
            if (customerorder.getTaxAmount() != 0) {
                customerorder1.setTaxAmount(customerorder.getTaxAmount());
            }
            if (customerorder.getOrderCurrency() != null) {
                customerorder1.setOrderCurrency(customerorder.getOrderCurrency());
            }
            if (customerorder.getStatus() != null) {
                customerorder1.setStatus(customerorder.getStatus());
            }
            if (customerorder.getTransactionStatus() != null) {
                customerorder1.setTransactionStatus(customerorder.getTransactionStatus());
            }
            if (customerorder.getReferenceNo() != null) {
                customerorder1.setReferenceNo(customerorder.getReferenceNo());
            }
            if (customerorder.getPaymentMode() != null) {
                customerorder1.setPaymentMode(customerorder.getPaymentMode());
            }
            if (customerorder.getTransactionMessage() != null) {
                customerorder1.setTransactionMessage(customerorder.getTransactionMessage());
            }
            if (customerorder.getCreatedBy() != 0) {
                customerorder1.setCreatedBy(customerorder.getCreatedBy());
            }
            if (customerorder.getCreatedAt() != null) {
                customerorder1.setCreatedAt(customerorder.getCreatedAt());
            }

            return customerorderRepo.save(customerorder1);
        } catch (
                RuntimeException e) {
            log.error("update error");
            throw new RuntimeException("failed to update customer", e);
        }
    }
   @Override
    public CustomerOrder getCostomerorderByid(int id) {
        try {
            return customerorderRepo.findById(id).orElseThrow(() -> new RuntimeException("customer order not found"));
        }catch (Exception e){
            throw new RuntimeException("failed to get customer",e);
        }
    }

    @Override
    public List<CustomerOrder> getBycustomerid(int CustomerId) {
        return customerorderRepo.findBycustomerId(CustomerId);
    }


}


