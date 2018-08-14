package com.product.management.productmanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@Builder
@ToString
public class ActionLogDto{

    private String id;
    private String principal;
    private Timestamp time;
    private String message;
    private String type;
}
