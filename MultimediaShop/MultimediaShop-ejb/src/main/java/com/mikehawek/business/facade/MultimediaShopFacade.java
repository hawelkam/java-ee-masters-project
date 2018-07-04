/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikehawek.business.facade;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mikehawek.business.ItemFactory;
import com.mikehawek.business.UserFactory;
import com.mikehawek.business.criteria.ItemNameSearchCriteria;
import com.mikehawek.business.dao.ItemManagement.ItemNameDao;
import com.mikehawek.business.dao.UserManagement.UserDao;
import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.dto.UserManagement.UserDto;
import com.mikehawek.integration.entities.itemnames.ItemName;
import com.mikehawek.integration.entities.users.User;
import com.mikehawek.integration.producer.ItemNameManagementProducer;

/**
 *
 * @author Hawek
 */
@Stateless
public class MultimediaShopFacade extends AbstractFacade<ItemNameDto> {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    @Inject
    private ItemNameManagementProducer itemNameManagementProducer;

    @Inject
    private ItemNameDao itemNameDao;

    @Inject
    private UserDao userDao;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MultimediaShopFacade() {
        super(ItemNameDto.class);

    }

    public void addItemName(ItemNameDto itemToAdd) {
        //validate dto
        itemNameManagementProducer.sendAddItemMessage(itemToAdd);
    }

    public void addItem(ItemDto itemDto) {

    }

    public List<ItemNameDto> searchItemNames(ItemNameSearchCriteria searchCriteria) {
        List<ItemName> itemNames = itemNameDao.findItemNames(searchCriteria);
        return itemNames.stream()
                .map(ItemFactory::createItemNameDto)
                .collect(Collectors.toList());
    }

    public void editItemName(ItemNameDto editedItem) {
        ItemName item = ItemFactory.createItemName(editedItem);
        getEntityManager().merge(item);
    }

    public void deleteItemName(String productCode) {
        itemNameManagementProducer.sendDeleteItemNameMessage(productCode);
    }

    public List<ItemNameDto> listItemNames() {
        List<ItemName> itemNames = itemNameDao.findItemNames(new ItemNameSearchCriteria());
        return itemNames.stream()
                .map(ItemFactory::createItemNameDto)
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto dto) {
        if (userDao.findUserWithLogin(dto.getLogin()).size() != 0) {
            return null;
        }
        User user = UserFactory.createUser(dto);
        userDao.save(user);
        return dto;
    }

    public UserDto login(String login, String password) {
        List<User> users = userDao.findUserWithCredentials(login, password);
        if (users.size() == 0) {
            return null;
        }
        return UserFactory.createUser(users.get(0));
    }
}
