package com.helpdesk.smart_helpdesk_ticketing.serviceImpl;

import com.helpdesk.smart_helpdesk_ticketing.dto.UserRequestDTO;
import com.helpdesk.smart_helpdesk_ticketing.model.User;
import com.helpdesk.smart_helpdesk_ticketing.repository.UserRepository;
import com.helpdesk.smart_helpdesk_ticketing.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserRequestDTO request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setTeam(request.getTeam());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
