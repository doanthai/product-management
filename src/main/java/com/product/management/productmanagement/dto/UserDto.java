/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author thaidq2
 */
@Data
@ToString
@Builder
public class UserDto {

    private String username;
    private String passwordDigest;
    private String email;
    private String phone;
    private String displayName;
    private Short gender;
    private String address;
    private String avatar;
    private Timestamp birthday;
    private String activationDigest;
    private Boolean activated;
    private Timestamp activatedAt;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private String resetDigest;
    private Timestamp resetSentAt;
    private String role;
}
