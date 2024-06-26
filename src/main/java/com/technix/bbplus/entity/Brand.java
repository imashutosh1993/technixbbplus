package com.technix.bbplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblbrands")
public class Brand {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brandName;

    private String description;

    private int createdBy;

    private Timestamp createdAt;

    private int companyId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId",referencedColumnName = "Id",insertable = false,updatable = false,nullable = false)
    private Company company;
}
