/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thaidq2
 */
@Entity
@Table(name = "tbl_product_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductUnit.findAll", query = "SELECT t FROM TblProductUnit t")
    , @NamedQuery(name = "TblProductUnit.findByProdId", query = "SELECT t FROM TblProductUnit t WHERE t.tblProductUnitPK.prodId = :prodId")
    , @NamedQuery(name = "TblProductUnit.findByUnitId", query = "SELECT t FROM TblProductUnit t WHERE t.tblProductUnitPK.unitId = :unitId")
    , @NamedQuery(name = "TblProductUnit.findByPrice", query = "SELECT t FROM TblProductUnit t WHERE t.price = :price")})
public class TblProductUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblProductUnitPK tblProductUnitPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblProduct tblProduct;
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblUnit tblUnit;

    public TblProductUnit() {
    }

    public TblProductUnit(TblProductUnitPK tblProductUnitPK) {
        this.tblProductUnitPK = tblProductUnitPK;
    }

    public TblProductUnit(int prodId, int unitId) {
        this.tblProductUnitPK = new TblProductUnitPK(prodId, unitId);
    }

    public TblProductUnitPK getTblProductUnitPK() {
        return tblProductUnitPK;
    }

    public void setTblProductUnitPK(TblProductUnitPK tblProductUnitPK) {
        this.tblProductUnitPK = tblProductUnitPK;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TblProduct getTblProduct() {
        return tblProduct;
    }

    public void setTblProduct(TblProduct tblProduct) {
        this.tblProduct = tblProduct;
    }

    public TblUnit getTblUnit() {
        return tblUnit;
    }

    public void setTblUnit(TblUnit tblUnit) {
        this.tblUnit = tblUnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblProductUnitPK != null ? tblProductUnitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProductUnit)) {
            return false;
        }
        TblProductUnit other = (TblProductUnit) object;
        if ((this.tblProductUnitPK == null && other.tblProductUnitPK != null) || (this.tblProductUnitPK != null && !this.tblProductUnitPK.equals(other.tblProductUnitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TblProductUnit[ tblProductUnitPK=" + tblProductUnitPK + " ]";
    }
    
}
