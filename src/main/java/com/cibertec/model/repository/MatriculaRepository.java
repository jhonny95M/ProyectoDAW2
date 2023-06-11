package com.cibertec.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	/*
	 * Matricula findByIdalumnoAndIdcurso(Long id); List<Matricula>
	 * findByIdalumno(Long id);
	 */
}
