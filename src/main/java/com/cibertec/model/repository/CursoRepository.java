package com.cibertec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
