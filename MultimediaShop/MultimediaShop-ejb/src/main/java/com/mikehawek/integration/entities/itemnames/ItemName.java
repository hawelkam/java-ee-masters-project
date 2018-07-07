/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikehawek.integration.entities.itemnames;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mikehawek.business.enums.Medium;
import com.mikehawek.business.enums.MediumType;
import com.mikehawek.integration.entities.Item;

/**
 *
 * @author Hawek
 */
@Entity
@Table(name = "item_name")
public class ItemName implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String name;
    @Id
    @Column(name = "product_code")
    protected String productCode;

    protected double price;

    @Enumerated(EnumType.STRING)
    protected Medium medium;

    @Temporal(TemporalType.DATE)
    protected Date releaseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "distributor")
    private String distributor;

    @Column(name = "mediaType")
    private MediumType mediaType;


    @OneToMany(mappedBy = "itemName",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Item> items = new ArrayList<>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public Medium getMedium() { return medium; }

    public void setMedium(Medium medium) { this.medium = medium; }

    public Date getReleaseDate() { return releaseDate; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public MediumType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediumType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCode != null ? productCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemName)) {
            return false;
        }
        ItemName other = (ItemName) object;
        /*if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "com.mikehawek.integration.entities.itemnames.ItemName[ id=" + productCode + " ]";
    }
    
}
