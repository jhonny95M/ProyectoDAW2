package com.cibertec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.dto.UserRegistrationDTO;
import com.cibertec.model.Role;
import com.cibertec.model.User;
import com.cibertec.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/inicio")
    public ResponseEntity<UserRegistrationDTO> inicio() {
    	return new ResponseEntity<>(new UserRegistrationDTO(),HttpStatus.OK);
    }
    
	@PostMapping("/register-login")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        // Verificar si el usuario ya existe
    	System.out.println(userDTO.getPassword());
        if (userService.existsByUsername(userDTO.getUsername())) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso");
        }
        // Crear una nueva instancia de User
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        
        // Crear y asignar los roles al usuario
        List<Role> roles = new ArrayList<>();
        for (Long roleName : userDTO.getRoles()) {
            Role role = new Role();
            //role.setName(roleName);
            role.setId(roleName);            
            roles.add(role);
            /*user.getRoles().add(role);
            role.getUsers().add(user);*/
        }
        user.setRoles(roles);
        
        // Guardar el usuario en la base de datos
        userService.saveUser(user);
        
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
    
    // Otros métodos del controlador
}







