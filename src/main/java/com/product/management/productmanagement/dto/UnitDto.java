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
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author thaidq2
 */
@Data
@ToString
@Builder
public class UnitDto implements Serializable {

    private Integer unitId;
    private String unitName;
    private String unitDesc;
    private Timestamp createdAt;
    private Timestamp lastUpdatedAt;
    private String creatorUsername;
    private String lastUpdaterUsername;
    private Collection<ProductUnitDto> productUnitDtos;
}