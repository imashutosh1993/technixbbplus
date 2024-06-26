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
@Table(name = "tblcompanyadditional")
public class CompanyAdditional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double authorizedCapital;
    private double paidUpCapital;
    private int totalNumberOfShares;
    private double valueOfEachShare;
    private int createdBy;
    private Timestamp createdAt;

    private int companyId;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId",referencedColumnName = "id",insertable = false,updatable = false,nullable = false)
    private Company company;

}

