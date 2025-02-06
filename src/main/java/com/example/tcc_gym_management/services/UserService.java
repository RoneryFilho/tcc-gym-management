package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.dto.UserDTO;
import com.example.tcc_gym_management.entities.User;
import com.example.tcc_gym_management.repositories.UserRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto User não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getDocument(),userDTO.getEmail(), userDTO.getPhoneNumber());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User user){
        User updatedUser = findById(user.getId());
        updateData(updatedUser, user);
        userRepository.save(updatedUser);
    }

    private void updateData(User newUser,User user){
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setDocument(user.getDocument());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
    }
}
