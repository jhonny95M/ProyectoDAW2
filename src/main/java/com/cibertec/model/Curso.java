package com.cibertec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String nomcurso;
	
	@ManyToMany(mappedBy = "cursos")
    private List<Profesor> profesores = new ArrayList<>();
	@ManyToMany(mappedBy = "cursos")
    private List<Matricula> matriculas=new ArrayList<>();
	
	public Curso(Long idCurso) {
		this.id=idCurso;
	}
	public Curso() {}

}
