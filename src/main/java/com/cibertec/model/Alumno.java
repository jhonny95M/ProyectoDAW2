package com.cibertec.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_alumnos")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomalum;
	private String apealum;
	private String dnialum;
	private String celalum;
	private String fechalum;
	private String usualum;
	private String passalum;
	
	@OneToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "none"))
    private User usuario;

	
	public String getNomalum() {
		return nomalum;
	}
	public void setNomalum(String nomalum) {
		this.nomalum = nomalum;
	}
	public String getApealum() {
		return apealum;
	}
	public void setApealum(String apealum) {
		this.apealum = apealum;
	}
	public String getDnialum() {
		return dnialum;
	}
	public void setDnialum(String dnialum) {
		this.dnialum = dnialum;
	}
	public String getCelalum() {
		return celalum;
	}
	public void setCelalum(String celalum) {
		this.celalum = celalum;
	}
	public String getFechalum() {
		return fechalum;
	}
	public void setFechalum(String fechalum) {
		this.fechalum = fechalum;
	}
	public String getUsualum() {
		return usualum;
	}
	public void setUsualum(String usualum) {
		this.usualum = usualum;
	}
	public String getPassalum() {
		return passalum;
	}
	public void setPassalum(String passalum) {
		this.passalum = passalum;
	}
	@Override
	public String toString() {
		return "Alumno [idalumno=" + id + ", nomalum=" + nomalum + ", apealum=" + apealum + ", dnialum=" + dnialum
				+ ", celalum=" + celalum + ", fechalum=" + fechalum + ", usualum=" + usualum + ", passalum=" + passalum
				+ "]";
	}
}
