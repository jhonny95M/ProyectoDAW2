package com.cibertec.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	/*
	 * Matricula findByIdalumnoAndIdcurso(Long id); List<Matricula>
	 * findByIdalumno(Long id);
	 */
	@Query("select m "
			+ "from Matricula m  "
			/*
			 * + "left outer join users user1_ on matricula0_.user_id=user1_.id \r\n" +
			 * "left outer join tb_alumnos alumno2_ on user1_.id=alumno2_.user_id \r\n"
			 */
			+ "where m.usuario.id = :user_id")
	List<Matricula> findUsuarioById(@Param("user_id")Long user_id);
}
