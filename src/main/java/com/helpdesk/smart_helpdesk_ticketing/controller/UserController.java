package com.helpdesk.smart_helpdesk_ticketing.controller;

import com.helpdesk.smart_helpdesk_ticketing.dto.UserRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.User;
import com.helpdesk.smart_helpdesk_ticketing.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
