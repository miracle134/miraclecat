package com.mc.springxml.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import com.mc.springxml.sample.vo.SampleVO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

//@Entity
//@Getter
//@DynamicUpdate
//@NoArgsConstructor
//@Table(schema="panorama",name="sample")
public class Sample{
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long seq;
//
//    @Column(name="NAME", nullable=true, length=20)
//    private String name;
//
//    @Column(name="PASSWORD", nullable=true, length=20)
//    private String password;
//
//    @Column(name="MESSAGE", nullable=true, length=50)
//    private String message;
//
//    @Column(name="COMPANY_SEQ", nullable=true, length=50)
//    private Long company_seq;
//
//    @Column(name="REG_ID", nullable=true, length=50, updatable = false)
//    private String regId;
//
//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
//    @Column(name="REG_DT", nullable=true, updatable = false)
//    private Date regDt;
//
//    @Builder(builderMethodName = "InsertSampleBuilder")
//    public Sample(@NotNull SampleVO vo) {
//    	this.name = vo.getSName();
//    	this.password = vo.getSPassword();
//    	this.message = vo.getSMessage();
//    	this.regId = vo.getSRegId();
//    }
//
//    public void updateInfo(SampleVO vo) {
//    	this.name = vo.getSName();
//    	this.password = vo.getSPassword();
//    	this.message = vo.getSMessage();
//    }
    
}