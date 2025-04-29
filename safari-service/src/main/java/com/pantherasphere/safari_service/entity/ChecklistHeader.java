package com.pantherasphere.safari_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "checklistHeader")
@Data
public class ChecklistHeader {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "checklistId", columnDefinition = "uniqueidentifier")
    private UUID checklistId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "forestId", columnDefinition = "uniqueidentifier", nullable = false)
    private UUID forestId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "createdBy", columnDefinition = "uniqueidentifier", nullable = false)
    private UUID createdBy;

    @Column(name = "safariDate", nullable = false)
    private LocalDate safariDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "guideId", columnDefinition = "uniqueidentifier", nullable = false)
    private UUID guideId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "driverId", columnDefinition = "uniqueidentifier", nullable = false)
    private UUID driverId;

    @Column(name = "verified", columnDefinition = "bit")
    private Boolean verified = false;

    @Column(name = "modifiedAt")
    private java.time.LocalDateTime modifiedAt = java.time.LocalDateTime.now();
}
