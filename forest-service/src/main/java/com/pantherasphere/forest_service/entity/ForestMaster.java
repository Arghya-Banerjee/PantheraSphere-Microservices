package com.pantherasphere.forest_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "ForestMaster")
@Data
public class ForestMaster {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "forestId", columnDefinition = "uniqueidentifier")
    private UUID forestId;

    @Column(name = "forestName")
    private String forestName;

    @Column(name = "forestArea")
    private Double forestArea;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "forestTypeId", nullable = false)
    private ForestTypeMaster forestType;
}

