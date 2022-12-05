package com.mc.miraclecat.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(schema="panorama",name="NOTICE")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "NOTICE_ID", nullable = false)
    private long noticeId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "OPEN", nullable = false)
    private String open;

    @Column(name = "CREATED_ID", nullable = false)
    private long createdId;

    @Column(name = "CREATED_AT", nullable = false)
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATED_ID", nullable = false)
    private long lastUpdatedId;

    @Column(name = "LAST_UPDATED_AT", nullable = false)
    private Timestamp lastUpdatedAt;


}
