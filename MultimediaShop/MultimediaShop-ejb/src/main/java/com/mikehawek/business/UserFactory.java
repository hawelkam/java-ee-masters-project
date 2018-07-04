package com.mikehawek.business;

import com.mikehawek.business.dto.UserManagement.CustomerDto;
import com.mikehawek.business.dto.UserManagement.EmployeeDto;
import com.mikehawek.business.dto.UserManagement.UserDto;
import com.mikehawek.integration.entities.users.Customer;
import com.mikehawek.integration.entities.users.Employee;
import com.mikehawek.integration.entities.users.User;

public class UserFactory {
    public static User createUser(UserDto dto) {
        if(dto instanceof CustomerDto) {
            return createCustomer((CustomerDto) dto);
        } else if (dto instanceof EmployeeDto){
            return createEmployee((EmployeeDto) dto);
        } else {
            return null;
        }
    }

    private static Employee createEmployee(EmployeeDto dto) {
        Employee user = new Employee();
        user.setAddress(dto.getAddress());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setEmployeeId(dto.getEmployeeId());
        return user;
    }

    private static Customer createCustomer(CustomerDto dto) {
        Customer user = new Customer();
        user.setAddress(dto.getAddress());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserDto createUser(User user) {
        if(user instanceof Customer) {
            return createCustomerDto((Customer) user);
        } else if (user instanceof Employee){
            return createEmployeeDto((Employee) user);
        } else {
            return null;
        }
    }

    private static CustomerDto createCustomerDto(Customer user) {
        CustomerDto dto = new CustomerDto();
        dto.setAddress(user.getAddress());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        //dto.setBasket(user.getB); basket
        //dto.setOrders ORDERS
        return dto;
    }

    private static EmployeeDto createEmployeeDto(Employee user) {
        EmployeeDto dto = new EmployeeDto();
        dto.setAddress(user.getAddress());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        dto.setEmployeeId(user.getEmployeeId());
        return dto;
    }
}
