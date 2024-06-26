package com.technix.bbplus.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tblcustomersubscription")
public class Subscription {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int subsId;

        private int planId;

        private int planValidity;

        @Temporal(TemporalType.DATE)
        private Date planStart;

        @Temporal(TemporalType.DATE)
        private Date planEnd;

        private int status;

        private int createdBy;

        private Timestamp createdAt;

        private int customerId;

@JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,nullable = false,updatable = false)
        private Customer customer;

}
