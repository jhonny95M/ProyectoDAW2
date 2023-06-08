package com.cibertec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cibertec.model.Role;
import com.cibertec.model.User;
import com.cibertec.model.repository.RoleRepository;
import com.cibertec.model.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userRepository;
    @Autowired
    private RoleRepository repository;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	try {
    		System.out.println(username);
    	
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        //Set<Role> roles=repository.findByIdUser(user.getId());
        // Obtén los roles del usuario desde la base de datos
        //Hibernate.initialize(user.getRoles());
		  // Crea una lista de objetos GrantedAuthority basada en los roles del usuario
		  List<GrantedAuthority> authorities = new ArrayList<>(); 
		  for (Role role :user.getRoles()) 
		  { 
			  authorities.add(new SimpleGrantedAuthority(role.getName())); 
			  }
		  
		  // Crea y devuelve un objeto UserDetails con los detalles del usuario 
		  return
		  new org.springframework.security.core.userdetails.User( user.getUsername(),
		  user.getPassword(), authorities );
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    		return null;
		}
    }
}
