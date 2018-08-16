/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 *
 * @author thaidq2
 */
@Entity
@Table(name = "tbl_product_unit")
public class ProductUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductUnitId productUnitId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Min(value = 0)
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unit unit;

    public ProductUnit() {
    }

    public ProductUnit(ProductUnitId productUnitId) {
        this.productUnitId = productUnitId;
    }

    public ProductUnit(int prodId, int unitId) {
        this.productUnitId = new ProductUnitId(prodId, unitId);
    }

    public ProductUnitId getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(ProductUnitId productUnitId) {
        this.productUnitId = productUnitId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productUnitId != null ? productUnitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductUnit)) {
            return false;
        }
        ProductUnit other = (ProductUnit) object;
        return (this.productUnitId != null || other.productUnitId == null) && (this.productUnitId == null || this.productUnitId.equals(other.productUnitId));
    }

    @Override
    public String toString() {
        return "ProductUnitDto[ productUnitIdDto=" + productUnitId + " ]";
    }
    
}
