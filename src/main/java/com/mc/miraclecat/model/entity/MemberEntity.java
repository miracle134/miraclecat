package com.mc.miraclecat.model.entity;

import com.mc.miraclecat.member.vo.MemberVO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(schema = "panorama", name = "MEMBER")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID", updatable = false)
    private Long memberId;

    @Column(name = "EMAIL", updatable = false)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AUTHORITY")
    private String authority;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Column(name = "CREATED_ID")
    private Long createdId;

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    private Date createdAt;

    @Column(name = "LAST_UPDATED_ID", insertable = false)
    private Long lastUpdatedId;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED_AT", insertable = false)
    private Date lastUpdatedAt;

    @Builder(builderMethodName = "createMemberEntity")
    public MemberEntity(MemberVO memberVO) {
        this.email = memberVO.getEmail();
        this.password = memberVO.getPassword();
        this.authority = memberVO.getAuthority();
        this.name = memberVO.getName();
        this.address = memberVO.getAddress();
        this.cellPhone = memberVO.getCellPhone();
    }

    @PostPersist
    public void setMemberId(){
        this.createdId = this.memberId;
        this.lastUpdatedId = this.memberId;
    }

    public void patchMember(MemberVO memberVO){
        this.name = memberVO.getName();
        this.address = memberVO.getAddress();
        this.cellPhone = memberVO.getCellPhone();
    }

}
