package com.pantherasphere.safari_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "guideMaster")
@Data
public class GuideMaster {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "guideId", columnDefinition = "uniqueidentifier")
    private UUID guideId;

    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String email;
}