/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.management.productmanagement.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thaidq2
 */
@Entity
@Table(name = "tbl_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUnit.findAll", query = "SELECT t FROM TblUnit t")
    , @NamedQuery(name = "TblUnit.findByUnitId", query = "SELECT t FROM TblUnit t WHERE t.unitId = :unitId")
    , @NamedQuery(name = "TblUnit.findByUnitName", query = "SELECT t FROM TblUnit t WHERE t.unitName = :unitName")
    , @NamedQuery(name = "TblUnit.findByUnitDesc", query = "SELECT t FROM TblUnit t WHERE t.unitDesc = :unitDesc")
    , @NamedQuery(name = "TblUnit.findByCreatedAt", query = "SELECT t FROM TblUnit t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TblUnit.findByLastUpdatedAt", query = "SELECT t FROM TblUnit t WHERE t.lastUpdatedAt = :lastUpdatedAt")
    , @NamedQuery(name = "TblUnit.findByCreatorUsername", query = "SELECT t FROM TblUnit t WHERE t.creatorUsername = :creatorUsername")
    , @NamedQuery(name = "TblUnit.findByLastUpdaterUsername", query = "SELECT t FROM TblUnit t WHERE t.lastUpdaterUsername = :lastUpdaterUsername")})
public class TblUnit implements Serializable {

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
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "creator_username")
    private String creatorUsername;
    @Basic(optional = false)
    @Column(name = "last_updater_username")
    private String lastUpdaterUsername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblUnit")
    private Collection<ProductUnit> tblProductUnitCollection;

    public TblUnit() {
    }

    public TblUnit(Integer unitId) {
        this.unitId = unitId;
    }

    public TblUnit(Integer unitId, String unitName, Date createdAt, String creatorUsername, String lastUpdaterUsername) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
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
        if (!(object instanceof TblUnit)) {
            return false;
        }
        TblUnit other = (TblUnit) object;
        if ((this.unitId == null && other.unitId != null) || (this.unitId != null && !this.unitId.equals(other.unitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TblUnit[ unitId=" + unitId + " ]";
    }
    
}
