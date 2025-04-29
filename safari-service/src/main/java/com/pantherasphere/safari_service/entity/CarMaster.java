package com.pantherasphere.safari_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "carMaster")
@Data
public class CarMaster {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "carId", columnDefinition = "uniqueidentifier")
    private UUID carId;

    private String carNumberPlate;
    private String carModel;
}