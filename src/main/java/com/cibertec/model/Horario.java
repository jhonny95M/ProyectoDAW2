package com.cibertec.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_horarios")
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private String deshorario;
	@ManyToOne
    @JoinColumn(name = "profesorCurso_id",foreignKey = @ForeignKey(name = "none"))
    private ProfesorCurso profesorCurso;
	  
	
	public String getDeshorario() {
		return deshorario;
	}
	public void setDeshorario(String deshorario) {
		this.deshorario = deshorario;
	}
	@Override
	public String toString() {
		return "Horario [idhorario=" + id + ", deshorario=" + deshorario + "]";
	}
	public boolean seSuperponeCon(Horario otroHorario) {
        return inicio.isBefore(otroHorario.getFin()) && fin.isAfter(otroHorario.getInicio());
    }

}
