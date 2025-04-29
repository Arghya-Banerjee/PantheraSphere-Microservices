package com.pantherasphere.safari_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "ChecklistItem")
@Data
public class ChecklistItem {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "checklistItemId", columnDefinition = "uniqueidentifier")
    private UUID checklistItemId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "checklistId", columnDefinition = "uniqueidentifier", nullable = false)
    private UUID checklistId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "tigerId", columnDefinition = "uniqueidentifier", nullable = false)
    private UUID tigerId;

    @Column(name = "seenBy")
    private String seenBy;

    @Column(name = "seenTime")
    private Time seenTime;

    @Column(name = "observationNotes")
    private String observationNotes;
}
