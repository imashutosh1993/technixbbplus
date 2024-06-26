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
@Table(name = "tblcompanypartners")
public class PartnersDirectors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String directorName;
    private String directorIdentityNumber;
    private String adress;
    private String city;
    private String pin;
    private String state;
    private String country;
    private boolean executive;
    private String pan;
    private String aadhar;
    private String mobileNumber;
    private String email;
    private String digitalSignature;
    private int createdBy;
    private Timestamp createdAt;

    private int companyId;
@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId",referencedColumnName = "id",insertable = false,updatable = false,nullable = false)
    private Company company;

}
