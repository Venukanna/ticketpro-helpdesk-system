package com.helpdesk.smart_helpdesk_ticketing.service;

import com.helpdesk.smart_helpdesk_ticketing.dto.UserRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.User;

import java.util.List;

public interface UserService {

    User createUser( UserRequestDTO request);


    List<User> getAllUsers();

    void deleteUser(Long id);

}