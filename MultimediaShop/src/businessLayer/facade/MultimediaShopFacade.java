package businessLayer.facade;

import java.util.ArrayList;
import java.util.List;

import businessLayer.businessLayerEnums.MediaType;
import businessLayer.dataaccess.dto.ItemNameDto;
import businessLayer.dataaccess.dto.MovieNameDto;
import businessLayer.dataaccess.dto.MusicAlbumNameDto;
import businessLayer.dataaccess.dto.VideoGameNameDto;
import businessLayer.entity.itemNames.ItemName;
import businessLayer.factories.ItemFactory;

public class MultimediaShopFacade {

    private List<ItemName> itemNames;

    public MultimediaShopFacade() {
        this.itemNames = new ArrayList<>();

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
