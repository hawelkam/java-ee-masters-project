package com.mikehawek.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.dto.UserManagement.CustomerDto;
import com.mikehawek.business.dto.UserManagement.UserDto;

@Named
@javax.enterprise.context.SessionScoped
public class CustomerLoginBean implements Serializable {
    @EJB
    private com.mikehawek.business.facade.MultimediaShopFacade multimediaShopFacade;

    private String login;
    private String password;
    private CustomerDto loggedUser;
    private CustomerDto newUser = new CustomerDto();
    boolean edit;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(CustomerDto loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String performLogin() {
        loggedUser = (CustomerDto) multimediaShopFacade.login(login, password);
        if (loggedUser == null) {
            return "";
        }
        return "/index.xhtml";
    }

    public void cancelEdit() {
        this.newUser = new CustomerDto();
        edit = false;
    }

    public void saveEdit() {
        loggedUser = (CustomerDto) multimediaShopFacade.createUser(this.newUser);
        this.newUser = new CustomerDto();
        edit = false;
    }

    public void showNewUserDialog() {
        this.edit = true;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public UserDto getNewUser() {
        return newUser;
    }

    public void setNewUser(CustomerDto newUser) {
        this.newUser = newUser;
    }
}
