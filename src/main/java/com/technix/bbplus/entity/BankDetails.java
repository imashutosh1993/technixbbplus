package com.technix.bbplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tblcompanybankdetails")
public class BankDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bankAccountNature;
    private String accountNumber;
    private String bankName;
    private String branchName;
    private String branchAdress;
    private String ifscCode;
    private String signingAuthority;
    private String accountType;
    private String ibanNo;
    private String swiftCode;
    private String upiNo;
    private int createdBy;
    private Timestamp createdAt;

    private int companyId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId",referencedColumnName = "companyId",insertable = false,updatable = false,nullable = false)
    private Company company;

}
