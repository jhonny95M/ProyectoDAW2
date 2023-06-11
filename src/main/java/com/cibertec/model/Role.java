package com.cibertec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
	@Table(name = "roles")
	public class Role {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;	    
	    private String name;
	    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
	    private List<User> users = new ArrayList<>();
	    // Otros campos y relaciones
	    
	    // Getters y setters
	}
