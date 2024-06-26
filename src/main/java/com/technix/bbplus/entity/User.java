package com.technix.bbplus.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblusers")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;



    private String fullName;
    private String emailId;
    private String password;
    private int status;
    private int createdBy;
    private Timestamp createdAt;
    private String userType;

    private int customerId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId",referencedColumnName = "customerId", insertable = false,nullable = false, updatable = false)
    private Customer customers;



}
