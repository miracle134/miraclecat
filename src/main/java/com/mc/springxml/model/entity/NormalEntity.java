package com.mc.springxml.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(schema="panorama",name="NORMAL")
public class NormalEntity {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    private long memberId;

    @Column(name = "POSITION", nullable = false)
    private String position;

    @Column(name = "CREATED_ID", nullable = false)
    private long createdId;

    @Column(name = "CREATED_AT", nullable = false)
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATED_ID", nullable = false)
    private long lastUpdatedId;

    @Column(name = "LAST_UPDATED_AT", nullable = false)
    private Timestamp lastUpdatedAt;


}
