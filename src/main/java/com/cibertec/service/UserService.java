package com.cibertec.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Role;
import com.cibertec.model.User;
import com.cibertec.model.repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    public void saveUser(User user) {
        userRepository.save(user);        
    }
    public User findByUsername(String username) {
    	//User user = userRepository.findByUsername(username);
    	return userRepository.findByUsernameWithRoles(username);
    	//return user;
    }
    // Otros métodos de servicio
}
