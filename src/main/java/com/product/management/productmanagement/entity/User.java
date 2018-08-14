/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author thaidq2
 */
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

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
    private Timestamp birthday;
    @Column(name = "activation_digest")
    private String activationDigest;
    @Column(name = "activated")
    private Boolean activated;
    @Column(name = "activated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp activatedAt;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdatedAt;
    @Column(name = "reset_digest")
    private String resetDigest;
    @Column(name = "reset_sent_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp resetSentAt;
    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String passwordDigest, String phone, Timestamp createdAt) {
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

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
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

    public Timestamp getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(Timestamp activatedAt) {
        this.activatedAt = activatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getResetDigest() {
        return resetDigest;
    }

    public void setResetDigest(String resetDigest) {
        this.resetDigest = resetDigest;
    }

    public Timestamp getResetSentAt() {
        return resetSentAt;
    }

    public void setResetSentAt(Timestamp resetSentAt) {
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return (this.username != null || other.username == null) && (this.username == null || this.username.equals(other.username));
    }

    @Override
    public String toString() {
        return "User[ username=" + username + " ]";
    }
    
}
