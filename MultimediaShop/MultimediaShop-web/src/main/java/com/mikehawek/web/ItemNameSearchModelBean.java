package com.mikehawek.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mikehawek.business.criteria.ItemNameSearchCriteria;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class ItemNameSearchModelBean implements Serializable{

    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private ItemNameSearchCriteria itemNameSearchCriteria;

    private List<ItemNameDto> searchResult;

    private boolean detailsEnabled;
    private ItemNameDto details;

    @PostConstruct
    public void init() {
        itemNameSearchCriteria = new ItemNameSearchCriteria();
    }

    public void search() {
        disableDetails();
        searchResult = multimediaShopFacade.searchItemNames(this.itemNameSearchCriteria);
        if (searchResult == null || searchResult.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nie znaleziono żadnego przedmiotu spełniającego podane kryteria!", ""));
        }
        return;
    }

    public void resetSearch() {
        disableDetails();
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

    public void enableDetails(ItemNameDto itemNameDto) {
        this.details = itemNameDto;
        this.detailsEnabled = true;
    }

    public void disableDetails() {
        this.details = new ItemNameDto();
        this.detailsEnabled = false;
    }

    public boolean isDetailsEnabled() {
        return detailsEnabled;
    }

    public void setDetailsEnabled(boolean detailsEnabled) {
        this.detailsEnabled = detailsEnabled;
    }

    public ItemNameDto getDetails() {
        return details;
    }

    public void setDetails(ItemNameDto details) {
        this.details = details;
    }
}
