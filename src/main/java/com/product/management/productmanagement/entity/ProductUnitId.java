/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author thaidq2
 */
@Embeddable
public class ProductUnitId implements Serializable {

    @Basic(optional = false)
    @Column(name = "prod_id")
    private int prodId;
    @Basic(optional = false)
    @Column(name = "unit_id")
    private int unitId;

    public ProductUnitId() {
    }

    public ProductUnitId(int prodId, int unitId) {
        this.prodId = prodId;
        this.unitId = unitId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += prodId;
        hash += unitId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductUnitId)) {
            return false;
        }
        ProductUnitId other = (ProductUnitId) object;
        if (this.prodId != other.prodId) {
            return false;
        }
        return this.unitId == other.unitId;
    }

    @Override
    public String toString() {
        return "ProductUnitId[ prodId=" + prodId + ", unitId=" + unitId + " ]";
    }
    
}
