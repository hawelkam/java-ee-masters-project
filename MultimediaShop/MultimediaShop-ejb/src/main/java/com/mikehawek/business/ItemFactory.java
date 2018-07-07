package com.mikehawek.business;

import java.util.stream.Collectors;

import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.integration.entities.Item;
import com.mikehawek.integration.entities.itemnames.ItemName;

public class ItemFactory {
    public static ItemNameDto createItemNameDto(ItemName entity) {
        ItemNameDto itemNameDto = new ItemNameDto();
        itemNameDto.setName(entity.getName());
        itemNameDto.setProductCode(entity.getProductCode());
        itemNameDto.setPrice(entity.getPrice());
        itemNameDto.setMedium(entity.getMedium());
        itemNameDto.setReleaseDate(entity.getReleaseDate());
        itemNameDto.setDescription(entity.getDescription());
        itemNameDto.setAuthor(entity.getAuthor());
        itemNameDto.setDistributor(entity.getDistributor());
        itemNameDto.setMediaType(entity.getMediaType());
        if(entity.getItems() != null) {
            itemNameDto.setItems(entity.getItems().stream().map(i -> createItemDto(i)).collect(Collectors.toList()));
        }
        return itemNameDto;
    }

    public static ItemName createItemName(ItemNameDto itemNameDto) {
        ItemName itemName = new ItemName();
        itemName.setDescription(itemNameDto.getDescription());
        itemName.setMediaType(itemNameDto.getMediaType());
        itemName.setDistributor(itemNameDto.getDistributor());
        itemName.setAuthor(itemNameDto.getAuthor());
        itemName.setMedium(itemNameDto.getMedium());
        itemName.setName(itemNameDto.getName());
        itemName.setPrice(itemNameDto.getPrice());
        itemName.setProductCode(itemNameDto.getProductCode());
        itemName.setReleaseDate(itemNameDto.getReleaseDate());
        if(itemNameDto.getItems() != null) {
            itemName.setItems(itemNameDto.getItems().stream().map(i -> createItem(i)).collect(Collectors.toList()));
        }
        return itemName;
    }

    public static Item createItem(ItemDto dto) {
        Item item = new Item();
        item.setItemName(createItemName(dto.getItemNameDto()));
        item.setStatus(dto.getStatus());
        item.setBarCode(dto.getBarCode());
        return item;
    }

    public static ItemDto createItemDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setItemNameDto(createItemNameDto(item.getItemName()));
        dto.setStatus(dto.getStatus());
        dto.setBarCode(dto.getBarCode());
        return dto;
    }
}
