package com.technix.bbplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tblcompanies")
public class Company {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int companyId;

    private String companyName;

    private String businessType;

    private String cinNumber;
    private Date registrationDate;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String mobileNumber;
    private String fax;
    private String emailId;
    private String website;
    private String logo;
    private String logoPosition;
    private String logoOnInvoice;
    private int createdBy;
    private Timestamp createdAt;

    private int customerId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, nullable = false, updatable = false)
    private Customer customer;
}
