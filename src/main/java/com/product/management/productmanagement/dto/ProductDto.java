/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author thaidq2
 */
@Data
@Builder
@ToString
public class ProductDto {
    private Integer prodId;
    private String prodName;
    private String prodDesc;
    private String prodImage;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private String creatorUsername;
    private String lastCreatorUsername;
    private Collection<ProductUnitDto> productUnitDtos;
}
