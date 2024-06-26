package com.technix.bbplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblproduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productType;
    private String productName;
   // @Column(length = 55)
    private String shortName;
    private String description;
    private String image;
    private int categoryId;
    private int departmentId;
    private int brandId;
    private int manufacturerId;
    private int supplierId;
    private String unit;
    private String UQCCode;
    private int altUnitRequired;
    private String secondaryUnit;
    private String secondaryUnitUQC;
    private String defaultSalesUnit;
    private Double conversionFactor;
    private int manageItemBy;
    private int managementMethod;
    private int warrantyPeriod;
    private String barcode;
    private String SKU;
    private String modelNo;
    private String color;
    private String size;
    private int isTaxable;
    private int taxId;
    private String taxationType;
    private Double taxPer;
    private String HSNCode;
    private int reorderPoint;
    private Double MRP;
    private Double discountPer;
    private Double purchaseRate;
    private Double distributorPrice;
    private Double dealerPrice;
    private Double wholesalePrice;
    private Double sellingRate;
    private Double openingStock;
    private Double unitRate;
    private Double openingValue;
    private String bin;
    private String status;
    private int createdBy;
    private Timestamp creationDate;



    private int companyId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId",referencedColumnName = "id",insertable = false,updatable = false,nullable = false)
    private Company company;


@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "brandId",referencedColumnName = "id",insertable = false,updatable = false,nullable = false)
private Brand brand;

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "departmentId",referencedColumnName = "Id",insertable = false,updatable = false,nullable = false)
private Department department;

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "manufacturerId",referencedColumnName = "Id",insertable = false,updatable = false,nullable = false)
private Manufacturer manufacturer;

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "supplierId",referencedColumnName = "Id",insertable = false,updatable = false,nullable = false)
private Supplier supplier;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierId",referencedColumnName = "Id",insertable = false,updatable = false,nullable = false)
    private Category category;
}
