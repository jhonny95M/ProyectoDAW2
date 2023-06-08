package com.cibertec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmat;
	private String fechmat;
	private int idalumno;
	private int idcurso;
	private int idhorario;
	private int idprof;	
	
	public int getIdmat() {
		return idmat;
	}
	public void setIdmat(int idmat) {
		this.idmat = idmat;
	}
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public int getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	public int getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}
	public String getFechmat() {
		return fechmat;
	}
	public void setFechmat(String fechmat) {
		this.fechmat = fechmat;
	}
	public int getIdprof() {
		return idprof;
	}
	public void setIdprof(int idprof) {
		this.idprof = idprof;
	}
	@Override
	public String toString() {
		return "Matricula [idmat=" + idmat + ", fechmat=" + fechmat + ", idalumno=" + idalumno + ", idcurso=" + idcurso
				+ ", idhorario=" + idhorario + ", idprof=" + idprof + "]";
	}
}
