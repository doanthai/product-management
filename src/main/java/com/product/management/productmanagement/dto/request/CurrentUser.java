package com.product.management.productmanagement.dto.request;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class CurrentUser {
    private String username;
    private String email;
    private String phone;
    private String displayName;
    private Integer gender;
    private String address;
    private String avatar;
    private Timestamp birthday;
    private String role;
}
