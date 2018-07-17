package com.mikehawek.business.dto.ItemManagement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mikehawek.business.enums.Medium;
import com.mikehawek.business.enums.MediumType;

public class ItemNameDto implements Serializable{
    protected String name;
    protected String productCode;
    protected double price;
    Medium medium;
    protected Date releaseDate;
    protected List<ItemDto> items;
    private String description;
    private String author;
    private String distributor;
    private MediumType mediaType;

    private boolean isEdited;

    public ItemNameDto() {
    }

    public ItemNameDto(String name, String productCode) {
        this.name = name;
        this.productCode = productCode;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getProductCode() { return productCode; }

    public void setProductCode(String productCode) { this.productCode = productCode; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public Medium getMedium() { return medium; }

    public void setMedium(Medium medium) { this.medium = medium; }

    public Date getReleaseDate() { return releaseDate; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public List<ItemDto> getItems() { return items; }

    public void setItems(List<ItemDto> items) { this.items = items; }

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
    public ItemNameDto clone() throws CloneNotSupportedException {
        return new ItemNameDto(name, productCode);
    }

    public void restore(ItemNameDto item) {
        this.productCode = item.getProductCode();
        this.name = item.getName();
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }
}