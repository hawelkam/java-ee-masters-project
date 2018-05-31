package businessLayer.entity.itemNames;

import java.util.Date;
import java.util.List;

import businessLayer.businessLayerEnums.Medium;
import businessLayer.entity.items.Item;

public class ItemName {
    private String name;
    private String productCode;
    private double price;
    private Medium medium;
    private Date releaseDate;
    private List<Item> items;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Nazwa: " + getName() + " Nosnik: " + getMedium().toString() + " Cena: " + getPrice();
    }
}
