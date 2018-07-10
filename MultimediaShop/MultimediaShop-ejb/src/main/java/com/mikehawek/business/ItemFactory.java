package com.mikehawek.business;

import java.util.stream.Collectors;

import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.business.enums.Medium;
import com.mikehawek.business.enums.MediumType;
import com.mikehawek.integration.entities.Item;
import com.mikehawek.integration.entities.itemnames.ItemName;

public class ItemFactory {

    public static ItemNameDto createItemNameDto(ItemName entity) {
        ItemNameDto itemNameDto = new ItemNameDto();
        itemNameDto.setName(entity.getName());
        itemNameDto.setProductCode(entity.getProductCode());
        itemNameDto.setPrice(entity.getPrice());
        if (entity.getMedium() != null)
            itemNameDto.setMedium(Medium.valueOf(entity.getMedium()));
        itemNameDto.setReleaseDate(entity.getReleaseDate());
        itemNameDto.setDescription(entity.getDescription());
        itemNameDto.setAuthor(entity.getAuthor());
        itemNameDto.setDistributor(entity.getDistributor());
        if (entity.getMediaType() != null)
            itemNameDto.setMediaType(MediumType.valueOf(entity.getMediaType()));
        if(entity.getItems() != null) {
            itemNameDto.setItems(entity.getItems().stream().map(i -> createItemDto(i)).collect(Collectors.toList()));
        }
        return itemNameDto;
    }

    public static ItemNameDto createItemNameDtoWithoutItems(ItemName entity) {
        ItemNameDto itemNameDto = new ItemNameDto();
        itemNameDto.setName(entity.getName());
        itemNameDto.setProductCode(entity.getProductCode());
        itemNameDto.setPrice(entity.getPrice());
        if (entity.getMedium() != null)
            itemNameDto.setMedium(Medium.valueOf(entity.getMedium()));
        itemNameDto.setReleaseDate(entity.getReleaseDate());
        itemNameDto.setDescription(entity.getDescription());
        itemNameDto.setAuthor(entity.getAuthor());
        itemNameDto.setDistributor(entity.getDistributor());
        if (entity.getMediaType() != null)
            itemNameDto.setMediaType(MediumType.valueOf(entity.getMediaType()));
        return itemNameDto;
    }

    public static ItemName createItemName(ItemNameDto itemNameDto) {
        ItemName itemName = new ItemName();
        itemName.setDescription(itemNameDto.getDescription());
        itemName.setDistributor(itemNameDto.getDistributor());
        itemName.setAuthor(itemNameDto.getAuthor());
        if (itemNameDto.getMediaType() != null)
            itemName.setMediaType(itemNameDto.getMediaType().toString());
        if (itemNameDto.getMedium() != null)
            itemName.setMedium(itemNameDto.getMedium().toString());
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
        if (dto.getStatus() != null)
            item.setStatus(dto.getStatus().toString());
        item.setBarCode(dto.getBarCode());
        return item;
    }

    public static ItemDto createItemDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setItemNameDto(createItemNameDtoWithoutItems(item.getItemName()));
        if (item.getStatus() != null)
            dto.setStatus(ItemStatus.valueOf(item.getStatus()));
        dto.setBarCode(item.getBarCode());
        if (item.getOrder() != null ) {
            dto.setOrderId(item.getOrder().getId());
        }
        return dto;
    }
}
