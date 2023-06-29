package com.cibertec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.dto.CursoDTO;
import com.cibertec.dto.CursoProfesorDTO;
import com.cibertec.dto.ProfesorDTO;
import com.cibertec.model.repository.CursoRepository;
import com.cibertec.model.repository.ProfesorCursoRepository;
import com.cibertec.response.CursoResponse;

@Service
public class CursoService {

	@Autowired
	private ProfesorCursoRepository proCursoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
    private HttpServletRequest request;
	
	public List<CursoProfesorDTO> getAllCursosAndProfesores() {
		List<CursoProfesorDTO>listaReturn=new ArrayList<>();
		List<CursoProfesorDTO>cursos=proCursoRepository.findCursoProfesorDTOsByEstado();
		// Agrupar por curso
        Map<CursoDTO, List<CursoProfesorDTO>> cursosById = cursos.stream()
                .collect(Collectors.groupingBy(CursoProfesorDTO::getCurso));
        
        // Imprimir los grupos
        for (Map.Entry<CursoDTO, List<CursoProfesorDTO>> entry : cursosById.entrySet()) {
        	CursoDTO idcurso = entry.getKey();
            List<CursoProfesorDTO> cursosWithId = entry.getValue();
            CursoProfesorDTO curso= cursosWithId.get(0);
            System.out.println("Age: " + idcurso);
            List<ProfesorDTO>profesores=new ArrayList<>(); 
            for (CursoProfesorDTO item : cursosWithId) {
                System.out.println(curso.getCurso().getNomcurso());
                profesores.addAll(item.getProfesores());
            }
            curso.setProfesores(profesores);
            listaReturn.add(curso);
            System.out.println();
        }
		return listaReturn;
	}
	public List<CursoResponse>findAll(){
		return cursoRepository.findAll()
				.stream()
				.map(curso -> 
				new CursoResponse(curso.getId(), curso.getNomcurso(),getBaseUrl()+"/"+curso.getUrlImage(),
						curso.getDescripcionCurso(),curso.getPrecio()))
	            .collect(Collectors.toList());
	}
	public String getBaseUrl() {
        StringBuilder baseUrl = new StringBuilder();
        baseUrl.append(request.getScheme()) // http or https
                .append("://")
                .append(request.getServerName()) // localhost or domain name
                .append(":")
                .append(request.getServerPort()); // port number

        return baseUrl.toString();

}
}
