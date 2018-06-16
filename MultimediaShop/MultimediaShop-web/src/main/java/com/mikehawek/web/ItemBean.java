package com.mikehawek.web;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.dto.ItemNameDto;
import com.mikehawek.business.dto.MovieNameDto;
import com.mikehawek.business.facade.ItemNameFacade;

@Named("itemBean")
@javax.enterprise.context.RequestScoped
public class ItemBean {
    @EJB
    private com.mikehawek.business.facade.ItemNameFacade itemNameFacade;

    private String name;
    private ItemNameDto itemName;
    private ItemNameDto beforeEditItemName;

    public void add() {
        // DAO save the add
        itemName = new MovieNameDto();
    }

    public void resetAdd() {
        itemName = new ItemNameDto();
    }

    public List<ItemNameDto> listItems() {
        return itemNameFacade.listItemNames();
    }

 /*   public void edit(ItemNameDto item) {
        beforeEditItemName = item.clone();
        this.itemName = item;
    }

    public void cancelEdit() {
        this.itemName.restore(beforeEditItemName);
        this.itemName = new ItemNameDto();
    }

    public void saveEdit() {
        // DAO save the edit
        this.itemName = new ItemNameDto();
    }

    public void delete(ItemNameDto item) throws IOException {
        // DAO save the delete
        itemName.remove(item);
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemNameFacade getItemNameFacade() {
        return itemNameFacade;
    }

    public void setItemNameFacade(ItemNameFacade itemNameFacade) {
        this.itemNameFacade = itemNameFacade;
    }

    public List<ItemNameDto> getItemNames() {
        return itemNameFacade.listItemNames();
    }

    public void setItemNames(List<ItemNameDto> itemNames) {
        //this.itemNames = itemNames;
    }
}
