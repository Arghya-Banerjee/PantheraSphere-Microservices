package com.pantherasphere.forest_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "ForestTypeMaster")
@Data
public class ForestTypeMaster {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "forestTypeId", columnDefinition = "uniqueidentifier")
    private UUID forestTypeId;

    @Column(name = "forestTypeName")
    private String forestTypeName;

    @Column(name = "description")
    private String description;
}

