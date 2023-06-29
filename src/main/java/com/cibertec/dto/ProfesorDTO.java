package com.cibertec.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProfesorDTO {
	private Long id;
	private String nombresprof;
	private String apePatprof;
	private String apeMatProf;
	private String espeprof;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	
	public ProfesorDTO(String nomprof, String apeprof,String apeMat, String espeprof,LocalDateTime inicio,LocalDateTime fin) {		
		this.nombresprof = nomprof;
		this.apePatprof = apeprof;
		this.apeMatProf=apeMat;
		this.espeprof = espeprof;
		this.inicio=inicio;
		this.fin=fin;
	}
	public ProfesorDTO(Long id,String nomprof, String apeprof,String apeMat, String espeprof,LocalDateTime inicio,LocalDateTime fin) {
		this.id=id;
		this.nombresprof = nomprof;
		this.apePatprof = apeprof;
		this.apeMatProf=apeMat;
		this.espeprof = espeprof;
		this.inicio=inicio;
		this.fin=fin;
	}
	public ProfesorDTO() {
	}
	

}
