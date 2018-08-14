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
@Table(name = "tbl_unit")
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unit_id")
    private Integer unitId;
    @Basic(optional = false)
    @Column(name = "unit_name")
    private String unitName;
    @Column(name = "unit_desc")
    private String unitDesc;
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
    @Basic(optional = false)
    @Column(name = "last_updater_username")
    private String lastUpdaterUsername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblUnit")
    private Collection<ProductUnit> tblProductUnitCollection;

    public Unit() {
    }

    public Unit(Integer unitId) {
        this.unitId = unitId;
    }

    public Unit(Integer unitId, String unitName, Timestamp createdAt, String creatorUsername, String lastUpdaterUsername) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.createdAt = createdAt;
        this.creatorUsername = creatorUsername;
        this.lastUpdaterUsername = lastUpdaterUsername;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
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

    public String getLastUpdaterUsername() {
        return lastUpdaterUsername;
    }

    public void setLastUpdaterUsername(String lastUpdaterUsername) {
        this.lastUpdaterUsername = lastUpdaterUsername;
    }

    @XmlTransient
    public Collection<ProductUnit> getTblProductUnitCollection() {
        return tblProductUnitCollection;
    }

    public void setTblProductUnitCollection(Collection<ProductUnit> tblProductUnitCollection) {
        this.tblProductUnitCollection = tblProductUnitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitId != null ? unitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        return (this.unitId != null || other.unitId == null) && (this.unitId == null || this.unitId.equals(other.unitId));
    }

    @Override
    public String toString() {
        return "Unit[ unitId=" + unitId + " ]";
    }
    
}
