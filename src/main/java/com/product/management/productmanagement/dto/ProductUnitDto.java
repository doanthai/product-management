/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author thaidq2
 */
@Data
@ToString
@Builder
public class ProductUnitDto {

    protected ProductUnitIdDto productUnitIdDto;
    private Double price;
    private ProductDto productDto;
    private UnitDto unitDto;
}