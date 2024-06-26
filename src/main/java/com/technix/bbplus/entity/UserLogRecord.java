package com.technix.bbplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbluserslogs")
public class UserLogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String browser;

    private String platform;

    private String ipAdress;

    private String city;

    private String region;

    private String country;

    private String postal;

    private String location;

    private String isp;

    private Timestamp loginAt;



}
