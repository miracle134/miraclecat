package com.mc.miraclecat.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(schema="panorama",name="ADMIN")
public class AdminEntity {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    private long memberId;

    @Column(name = "ADMIN_POINT", nullable = false)
    private String adminPoint;

    @Column(name = "CREATED_ID", nullable = false)
    private long createdId;

    @Column(name = "CREATED_AT", nullable = false)
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATED_ID", nullable = false)
    private long lastUpdatedId;

    @Column(name = "LAST_UPDATED_AT", nullable = false)
    private Timestamp lastUpdatedAt;


}
