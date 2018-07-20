package com.mikehawek.web;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.dto.UserManagement.EmployeeDto;
import com.mikehawek.business.dto.UserManagement.UserDto;

@Named
@javax.enterprise.context.SessionScoped
public class EmployeeLoginBean implements Serializable {
    @EJB
    private com.mikehawek.business.facade.MultimediaShopFacade multimediaShopFacade;

    private String login;
    private String password;
    private EmployeeDto loggedUser;
    private EmployeeDto newUser = new EmployeeDto();
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

    public EmployeeDto getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(EmployeeDto loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String performLogin() {
        UserDto user = multimediaShopFacade.login(login, password);
        if (user != null && user instanceof EmployeeDto ) {
            loggedUser = (EmployeeDto) user;
            return "employeeIndex";
        } else {
            //loggedUser = null;
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", ""));
            return null;
        }
    }

    public void cancelEdit() {
        this.newUser = new EmployeeDto();
        edit = false;
    }

    public void saveEdit() {
        loggedUser = (EmployeeDto) multimediaShopFacade.createUser(this.newUser);
        this.newUser = new EmployeeDto();
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

    public EmployeeDto getNewUser() {
        return newUser;
    }

    public void setNewUser(EmployeeDto newUser) {
        this.newUser = newUser;
    }

    public void isLoggedIn() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if(loggedUser == null) {
            ConfigurableNavigationHandler nav
                    = (ConfigurableNavigationHandler)
                    facesContext.getApplication().getNavigationHandler();

            nav.performNavigation("no-access");
        }
    }

    public void performLogout() {
        loggedUser = null;
        login = null;
        password = null;
    }
}
