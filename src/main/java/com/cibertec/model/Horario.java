package com.cibertec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_horarios")
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhorario;
	private String deshorario;
	  
	public int getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}
	public String getDeshorario() {
		return deshorario;
	}
	public void setDeshorario(String deshorario) {
		this.deshorario = deshorario;
	}
	@Override
	public String toString() {
		return "Horario [idhorario=" + idhorario + ", deshorario=" + deshorario + "]";
	}

}
