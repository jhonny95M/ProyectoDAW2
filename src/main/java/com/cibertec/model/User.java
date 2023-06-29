package com.cibertec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "none")),
        inverseJoinColumns = @JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "none"))
    )
    private List<Role> roles = new ArrayList<>();
    @OneToOne(mappedBy = "usuario")
    private Alumno alumno;
    
    
	
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	  private List<Matricula>
    matriculas=new ArrayList<>();
	 
    // Otros campos y relaciones
    
    // Getters y setters
}

