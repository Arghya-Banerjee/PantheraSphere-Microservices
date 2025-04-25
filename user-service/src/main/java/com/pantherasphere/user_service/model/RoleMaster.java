package com.pantherasphere.user_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roleMaster")
@Data
public class RoleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable = false, unique = true)
    private String roleName;

}
