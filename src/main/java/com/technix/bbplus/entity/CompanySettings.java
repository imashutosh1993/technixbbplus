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
@Table(name = "tblcompanysettings")
public class CompanySettings {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String currencySymbol;
    private String currencyName;
    private String dateFormat;
    private boolean suffixSymbolToAmount;
    private boolean showInMillions;
    private int numberOfDecimalPlace;
    private String wordRepresentingAmountAfterDecimalPlace;
    private int noOfDecimalPlacesForAmountInWords;
    private int createdBy;
    private Timestamp createdAt;

    private int companyId;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId",referencedColumnName = "companyId",insertable = false,updatable = false,nullable = false)
    private Company company;

}
