package com.mikehawek.business.dto;

import java.util.Date;
import java.util.List;

import com.mikehawek.business.enums.Medium;

public class ItemNameDto {
    protected String name;
    protected String productCode;
    protected double price;
    Medium medium;
    protected Date releaseDate;
    protected List<ItemDto> items;

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
}