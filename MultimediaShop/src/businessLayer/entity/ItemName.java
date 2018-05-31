package businessLayer.entity;

import java.util.Date;

import businessLayer.businessLayerEnums.Medium;

public class ItemName {
    private String name;
    private String productCode;
    private double price;
    private Medium medium;
    private Date releaseDate;

    public ItemName() {
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Nazwa: " + getName() + " Nosnik: " + getMedium().toString() + " Cena: " + getPrice();
    }
}
