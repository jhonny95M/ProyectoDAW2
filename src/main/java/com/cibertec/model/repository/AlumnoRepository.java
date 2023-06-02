package com.cibertec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	Alumno findByUsualumAndPassalum(String Usualum,String Passalum);
	
}
