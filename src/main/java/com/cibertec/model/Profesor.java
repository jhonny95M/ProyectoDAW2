package com.cibertec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprof;
	private String nombresprof;
	private String apePatProf;
	private String apeMatProf;
	private String espeprof;
	private String dniprof;
	private String celprof;
	
	@ManyToMany
    @JoinTable(
        name = "profesor_curso",
        joinColumns = @JoinColumn(name = "profesor_id",foreignKey = @ForeignKey(name = "none")),
        inverseJoinColumns = @JoinColumn(name = "curso_id",foreignKey = @ForeignKey(name = "none"))
    )
    private List<Curso> cursos = new ArrayList<>();
	
	public Profesor(Long idProfesor) {
		this.idprof=idProfesor;
	}
	public Profesor() {}
	@Override
	public String toString() {
		return "Profesor [idprof=" + idprof + ", nomprof=" + nombresprof + ", apeprof=" + apePatProf + ", espeprof=" + espeprof
				+ ", dniprof=" + dniprof + ", celprof=" + celprof + "]";
	}
	
}
