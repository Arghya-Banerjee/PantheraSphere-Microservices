package com.pantherasphere.safari_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "driverCarAssignment")
@Data
public class DriverCarAssignment {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "assignmentId", columnDefinition = "uniqueidentifier")
    private UUID assignmentId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "driverId", columnDefinition = "uniqueidentifier")
    private UUID driverId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "carId", columnDefinition = "uniqueidentifier")
    private UUID carId;

    private LocalDateTime assignmentStart;
    private LocalDateTime assignmentEnd;
}