/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author thaidq2
 */
@Embeddable
public class TblProductUnitPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "prod_id")
    private int prodId;
    @Basic(optional = false)
    @Column(name = "unit_id")
    private int unitId;

    public TblProductUnitPK() {
    }

    public TblProductUnitPK(int prodId, int unitId) {
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
        hash += (int) prodId;
        hash += (int) unitId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProductUnitPK)) {
            return false;
        }
        TblProductUnitPK other = (TblProductUnitPK) object;
        if (this.prodId != other.prodId) {
            return false;
        }
        if (this.unitId != other.unitId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TblProductUnitPK[ prodId=" + prodId + ", unitId=" + unitId + " ]";
    }
    
}
