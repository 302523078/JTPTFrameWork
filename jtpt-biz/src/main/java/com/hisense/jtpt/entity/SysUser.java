package com.hisense.jtpt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.hisense.core.util.MyDatetimeDeserializer;
import com.hisense.core.util.MyDatetimeSerializer;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2014-06-26 10:01:40 .
 */
@Entity
@Table(name = "SYS_USER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_USER_ID")
    @SequenceGenerator(name = "SEQ_SYS_USER_ID", sequenceName = "SEQ_SYS_USER_ID", allocationSize = 1)
    @Column(name = "SYS_USER_ID")
    private Long sysUserId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_REAL_NAME")
    private String userRealName;
    @Column(name = "USER_TYPE")
    private String userType;
    @Column(name = "RES_ORG_NAME")
    private String resOrgId;
    // @Column(name="SYS_ORG_ID")
    // private Long sysOrgId;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "USER_PWD")
    private String userPwd;
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "DEL_FLG")
    private String delFlg;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_TIME")
    private Date updateTime;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "UPDATE_USERID")
    private String updateUserid;
    @Column(name = "CREATE_USERID")
    private String createUserid;
    @Column(name = "DEL_USERID")
    private String delUserid;
    @Column(name = "DEL_TIME")
    private Date delTime;

    @Column(name = "SYS_ORG_ID")
    private Long sysOrgId;

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setResOrgId(String resOrgId) {
        this.resOrgId = resOrgId;
    }

    public String getResOrgId() {
        return resOrgId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonDeserialize(using = MyDatetimeDeserializer.class)
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonSerialize(using = MyDatetimeSerializer.class)
    public Date getCreateDate() {
        return createDate;
    }

    @JsonDeserialize(using = MyDatetimeDeserializer.class)
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @JsonSerialize(using = MyDatetimeSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(String updateUserid) {
        this.updateUserid = updateUserid;
    }

    public String getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    public String getDelUserid() {
        return delUserid;
    }

    public void setDelUserid(String delUserid) {
        this.delUserid = delUserid;
    }

    @JsonDeserialize(using = MyDatetimeDeserializer.class)
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    @JsonSerialize(using = MyDatetimeSerializer.class)
    public Date getDelTime() {
        return delTime;
    }

    public String getKeyValues() {
        StringBuffer sb = new StringBuffer();
        sb.append(sysUserId);
        return sb.toString();
    }


    public void setSysOrgId(Long sysOrgId) {
        this.sysOrgId = sysOrgId;
    }

    public Long getSysOrgId() {
        return sysOrgId;
    }
}