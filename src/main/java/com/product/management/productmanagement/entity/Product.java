/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author thaidq2
 */
@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_id")
    private Integer prodId;
    @Basic(optional = false)
    @Column(name = "prod_name")
    private String prodName;
    @Column(name = "prod_desc")
    private String prodDesc;
    @Column(name = "prod_image")
    private String prodImage;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "creator_username")
    private String creatorUsername;
    @Column(name = "last_creator_username")
    private String lastCreatorUsername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblProduct")
    private Collection<ProductUnit> tblProductUnitCollection;

    public Product() {
    }

    public Product(Integer prodId) {
        this.prodId = prodId;
    }

    public Product(Integer prodId, String prodName, Timestamp createdAt, String creatorUsername) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.createdAt = createdAt;
        this.creatorUsername = creatorUsername;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    public String getLastCreatorUsername() {
        return lastCreatorUsername;
    }

    public void setLastCreatorUsername(String lastCreatorUsername) {
        this.lastCreatorUsername = lastCreatorUsername;
    }

    @XmlTransient
    public Collection<ProductUnit> getProductUnitCollection() {
        return tblProductUnitCollection;
    }

    public void setProductUnitCollection(Collection<ProductUnit> tblProductUnitCollection) {
        this.tblProductUnitCollection = tblProductUnitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        return (this.prodId != null || other.prodId == null) && (this.prodId == null || this.prodId.equals(other.prodId));
    }

    @Override
    public String toString() {
        return "Product[ prodId=" + prodId + " ]";
    }
    
}
