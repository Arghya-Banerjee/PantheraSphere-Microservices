package com.pantherasphere.safari_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "driverMaster")
@Data
public class DriverMaster {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "driverId", columnDefinition = "uniqueidentifier")
    private UUID driverId;

    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String email;
}