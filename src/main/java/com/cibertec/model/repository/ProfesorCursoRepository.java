package com.cibertec.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.dto.CursoProfesorDTO;
import com.cibertec.dto.ProfesorCursoDTO;
import com.cibertec.model.ProfesorCurso;

@Repository
public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, Long> {

	/*
	 * @Query("SELECT new com.cibertec.dto.CursoProfesorDTO(c.id, c.nomcurso,p) " +
	 * "FROM ProfesorCurso pc " + "JOIN pc.curso c " + "JOIN pc.profesor p " +
	 * "WHERE pc.estado.id = 1")
	 */
	@Query("SELECT new com.cibertec.dto.CursoProfesorDTO(c.id, c.nomcurso,h.inicio, h.fin,  p) "
            + "FROM ProfesorCurso pc "
            + "JOIN pc.curso c "
            + "JOIN pc.profesor p "
            + "LEFT JOIN pc.horarios h "
            + "WHERE pc.estado.id = 1")
    List<CursoProfesorDTO> findCursoProfesorDTOsByEstado();
    @Query("SELECT new com.cibertec.dto.ProfesorCursoDTO(p.idprof, p.nombresprof,p.apePatProf,p.apeMatProf,p.espeprof,h.inicio, h.fin,c) " +
            "FROM ProfesorCurso pc " +
            "JOIN pc.curso c " +
            "JOIN pc.profesor p " +
            "LEFT JOIN pc.horarios h " +
            "WHERE pc.estado.id = 1")
    List<ProfesorCursoDTO> findProfesorWithCursoDTOsByEstado();
	/*
	 * @Query("SELECT pc FROM ProfesorCurso pc WHERE pc.profesor.idprof = :idProfesor AND pc.curso.id = :idCurso"
	 * ) ProfesorCurso findByCursoAndProfesor(@Param("idProfesor") Long
	 * idProfesor,@Param("idcurso") Long idcurso);
	 */
    @Query("SELECT pc FROM ProfesorCurso pc WHERE pc.curso.id = :idCurso AND pc.profesor.id = :idProfesor")
    Optional<ProfesorCurso> findByCursoAndProfesor(@Param("idCurso") Long idCurso, @Param("idProfesor") Long idProfesor);

}

