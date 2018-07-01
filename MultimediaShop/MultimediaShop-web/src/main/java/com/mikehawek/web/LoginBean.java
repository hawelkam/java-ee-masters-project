package com.mikehawek.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.dto.UserDto;

@Named
@javax.enterprise.context.SessionScoped
public class LoginBean implements Serializable {
    @EJB
    private com.mikehawek.business.facade.ItemNameFacade itemNameFacade;

    private String login;
    private String password;
    private UserDto loggedUser;

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

    public void setLoggedUser(UserDto loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String performLogin() {
        //userFacade.login
        //if returned user - assign it to userDto
        //else msg "Invalid login/password
        return "searchItems";
    }
}
