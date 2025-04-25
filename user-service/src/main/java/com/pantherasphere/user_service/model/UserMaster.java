package com.pantherasphere.user_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "userMaster")
@Data
public class UserMaster {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID userId;
    private String username;
    private String email;
    private String passCode;
    private String phoneNumber;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "roleId")
    private RoleMaster role;

}
