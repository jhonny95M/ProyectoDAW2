package com.cibertec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprof;
	private String nomprof;
	private String apeprof;
	private String espeprof;
	private String dniprof;
	private String celprof;
	
	public int getIdprof() {
		return idprof;
	}
	public void setIdprof(int idprof) {
		this.idprof = idprof;
	}
	public String getNomprof() {
		return nomprof;
	}
	public void setNomprof(String nomprof) {
		this.nomprof = nomprof;
	}
	public String getApeprof() {
		return apeprof;
	}
	public void setApeprof(String apeprof) {
		this.apeprof = apeprof;
	}
	public String getEspeprof() {
		return espeprof;
	}
	public void setEspeprof(String espeprof) {
		this.espeprof = espeprof;
	}
	public String getDniprof() {
		return dniprof;
	}
	public void setDniprof(String dniprof) {
		this.dniprof = dniprof;
	}
	public String getCelprof() {
		return celprof;
	}
	public void setCelprof(String celprof) {
		this.celprof = celprof;
	}
	@Override
	public String toString() {
		return "Profesor [idprof=" + idprof + ", nomprof=" + nomprof + ", apeprof=" + apeprof + ", espeprof=" + espeprof
				+ ", dniprof=" + dniprof + ", celprof=" + celprof + "]";
	}
	
}
