package com.mikehawek.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.criteria.ItemNameSearchCriteria;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class ItemSearchModelBean implements Serializable{

    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private ItemNameSearchCriteria itemNameSearchCriteria;

    private List<ItemNameDto> searchResult;

    @PostConstruct
    public void init() {
        itemNameSearchCriteria = new ItemNameSearchCriteria();
    }

    public void search() {
        searchResult = multimediaShopFacade.searchItemNames(this.itemNameSearchCriteria);
        return;
    }

    public void resetSearch() {
        this.itemNameSearchCriteria = new ItemNameSearchCriteria();
        this.searchResult = new ArrayList<>();
    }

    public MultimediaShopFacade getMultimediaShopFacade() {
        return multimediaShopFacade;
    }

    public void setMultimediaShopFacade(MultimediaShopFacade multimediaShopFacade) {
        this.multimediaShopFacade = multimediaShopFacade;
    }

    public ItemNameSearchCriteria getItemNameSearchCriteria() {
        return itemNameSearchCriteria;
    }

    public void setItemNameSearchCriteria(ItemNameSearchCriteria itemNameSearchCriteria) {
        this.itemNameSearchCriteria = itemNameSearchCriteria;
    }

    public List<ItemNameDto> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<ItemNameDto> searchResult) {
        this.searchResult = searchResult;
    }
}
