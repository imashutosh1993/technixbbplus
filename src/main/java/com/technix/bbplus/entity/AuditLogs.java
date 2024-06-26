package com.technix.bbplus.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Table(name = "tblauditlogs")
@Data
public class AuditLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tableName;
    private String recordId;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private LocalDateTime createdAt;

    private int userId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId",insertable = false,nullable = false,updatable = false)
    private User user;



}
