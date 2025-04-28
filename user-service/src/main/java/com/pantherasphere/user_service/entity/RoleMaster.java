package com.pantherasphere.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roleMaster")
@Data
public class RoleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "roleName", nullable = false, unique = true)
    private String roleName;
}
