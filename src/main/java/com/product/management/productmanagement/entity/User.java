/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thaidq2
 */
@Entity
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t")
    , @NamedQuery(name = "TblUser.findByUsername", query = "SELECT t FROM TblUser t WHERE t.username = :username")
    , @NamedQuery(name = "TblUser.findByPasswordDigest", query = "SELECT t FROM TblUser t WHERE t.passwordDigest = :passwordDigest")
    , @NamedQuery(name = "TblUser.findByEmail", query = "SELECT t FROM TblUser t WHERE t.email = :email")
    , @NamedQuery(name = "TblUser.findByPhone", query = "SELECT t FROM TblUser t WHERE t.phone = :phone")
    , @NamedQuery(name = "TblUser.findByDisplayName", query = "SELECT t FROM TblUser t WHERE t.displayName = :displayName")
    , @NamedQuery(name = "TblUser.findByGender", query = "SELECT t FROM TblUser t WHERE t.gender = :gender")
    , @NamedQuery(name = "TblUser.findByAddress", query = "SELECT t FROM TblUser t WHERE t.address = :address")
    , @NamedQuery(name = "TblUser.findByAvatar", query = "SELECT t FROM TblUser t WHERE t.avatar = :avatar")
    , @NamedQuery(name = "TblUser.findByBirthday", query = "SELECT t FROM TblUser t WHERE t.birthday = :birthday")
    , @NamedQuery(name = "TblUser.findByActivationDigest", query = "SELECT t FROM TblUser t WHERE t.activationDigest = :activationDigest")
    , @NamedQuery(name = "TblUser.findByActivated", query = "SELECT t FROM TblUser t WHERE t.activated = :activated")
    , @NamedQuery(name = "TblUser.findByActivatedAt", query = "SELECT t FROM TblUser t WHERE t.activatedAt = :activatedAt")
    , @NamedQuery(name = "TblUser.findByCreatedAt", query = "SELECT t FROM TblUser t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TblUser.findByLastUpdatedAt", query = "SELECT t FROM TblUser t WHERE t.lastUpdatedAt = :lastUpdatedAt")
    , @NamedQuery(name = "TblUser.findByResetDigest", query = "SELECT t FROM TblUser t WHERE t.resetDigest = :resetDigest")
    , @NamedQuery(name = "TblUser.findByResetSentAt", query = "SELECT t FROM TblUser t WHERE t.resetSentAt = :resetSentAt")
    , @NamedQuery(name = "TblUser.findByRole", query = "SELECT t FROM TblUser t WHERE t.role = :role")})
public class TblUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password_digest")
    private String passwordDigest;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "gender")
    private Short gender;
    @Column(name = "address")
    private String address;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "activation_digest")
    private String activationDigest;
    @Column(name = "activated")
    private Boolean activated;
    @Column(name = "activated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activatedAt;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Column(name = "reset_digest")
    private String resetDigest;
    @Column(name = "reset_sent_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetSentAt;
    @Column(name = "role")
    private String role;

    public TblUser() {
    }

    public TblUser(String username) {
        this.username = username;
    }

    public TblUser(String username, String passwordDigest, String phone, Date createdAt) {
        this.username = username;
        this.passwordDigest = passwordDigest;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getActivationDigest() {
        return activationDigest;
    }

    public void setActivationDigest(String activationDigest) {
        this.activationDigest = activationDigest;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Date getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(Date activatedAt) {
        this.activatedAt = activatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getResetDigest() {
        return resetDigest;
    }

    public void setResetDigest(String resetDigest) {
        this.resetDigest = resetDigest;
    }

    public Date getResetSentAt() {
        return resetSentAt;
    }

    public void setResetSentAt(Date resetSentAt) {
        this.resetSentAt = resetSentAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TblUser[ username=" + username + " ]";
    }
    
}
