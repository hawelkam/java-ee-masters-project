package server.business.facade;

import java.util.ArrayList;
import java.util.List;

import server.business.enums.MediaType;
import server.dataaccess.ItemNameDto;
import server.dataaccess.MovieNameDto;
import server.dataaccess.MusicAlbumNameDto;
import server.dataaccess.VideoGameNameDto;
import server.integration.entity.itemNames.ItemName;
import server.factories.ItemFactory;

public class MultimediaShopFacade {

    private List<ItemName> itemNames;

    public MultimediaShopFacade() {
        this.itemNames = new ArrayList<ItemName>();

    }

    public String addItemName(MediaType mediaType, ItemNameDto dto) {
        ItemName newItem = new ItemName();
        switch (mediaType) {
            case Movie:
                newItem = ItemFactory.createMovieName((MovieNameDto) dto);
                break;
            case VideoGame:
                newItem = ItemFactory.createVideoGameName((VideoGameNameDto) dto);
                break;
            case MusicAlbum:
                newItem = ItemFactory.createMusicAlbumName((MusicAlbumNameDto) dto);
                break;
        }
        if (searchItemName(newItem) == null) {
            itemNames.add(newItem);
            return newItem.toString();
        }
        return null;
    }

    public ItemName searchItemName(ItemName newItem) {
        int idx;
        if ((idx = itemNames.indexOf(newItem)) != -1) {
            newItem = itemNames.get(idx);
            return newItem;
        }
        return null;
    }

    public List<ItemName> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<ItemName> itemNames) {
        this.itemNames = itemNames;
    }
}
