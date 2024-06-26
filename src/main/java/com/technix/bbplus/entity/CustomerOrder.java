package com.technix.bbplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Tblcustomerorder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderId;

    private Date orderDate;

    private int planId;

    private double planRate;

    private int planValidity;

    private double planValue;

    private double subTotal;

    private double discount;

    private double totalAmount;

    private double texableValue;

    private double taxAmount;

    private String orderCurrency;

    private String status;

    private String transactionStatus;

    private String referenceNo;

    private String paymentMode;

    private String transactionMessage;

    private int createdBy;

    private Timestamp createdAt;

    private int customerId;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,nullable = false,updatable = false)
    private Customer customer;




}
