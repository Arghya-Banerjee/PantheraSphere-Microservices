package com.pantherasphere.tiger_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tigerMaster")
@Data
public class TigerMaster {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "tigerId", columnDefinition = "uniqueidentifier")
    private UUID tigerId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "residentForestId", nullable = false)
    private UUID residentForestId;

    @Column(name = "lastSighted")
    private LocalDateTime lastSighted;

    @Column(name = "addedBy")
    private UUID addedBy;

    @Column(name = "addedDate")
    private LocalDateTime addedDate;
}

