package com.cibertec.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime fechmat;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinTable(name = "matricula",
     joinColumns = @JoinColumn(name = "matricula_id",foreignKey = @ForeignKey(name = "none")),
     inverseJoinColumns = @JoinColumn(name = "curso_id",foreignKey = @ForeignKey(name = "none")))
    private List<Curso> cursos=new ArrayList<>();
    
	@ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "none"))
    private User usuario;
    
	
	
}
