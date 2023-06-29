package com.cibertec.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cibertec.dto.CursoProfesorDTO;
import com.cibertec.response.CursoResponse;
import com.cibertec.response.OkResponse;
import com.cibertec.service.CursoService;
import com.cibertec.viewmodel.Carrito;

@RestController
@RequestMapping("/api/cart")
@SessionAttributes("carrito")
public class ApiCarritoController {
	
	@Autowired
    private HttpSession session;
	
	@Autowired
	CursoService cursoService;

    @PostMapping("/agregar")
    public ResponseEntity<OkResponse> agregarProducto(@RequestBody CursoResponse curso) throws ValidationException {
        Carrito carrito = obtenerCarrito();
        if(carrito.getContenido().stream().anyMatch(c->c.getId()==curso.getId()))
        	throw new ValidationException("Ya fue agregado el curso "+curso.getNomcurso()+".");
        carrito.agregarProducto(curso);
        session.setAttribute("carrito", carrito);
        return ResponseEntity.ok(new OkResponse("Curso agregado exitosamente."));
    }

    @DeleteMapping("/eliminar/{idCurso}")
    public ResponseEntity<OkResponse> eliminarProducto(@PathVariable("idCurso") Long idCurso) {
        Carrito carrito = obtenerCarrito();
        carrito.eliminarProducto(idCurso);
		/*
		 * List<CursoResponse> contenid=carrito.getContenido();
		 * session.setAttribute("carrito", carrito);
		 */
        return ResponseEntity.ok(new OkResponse("El curso fue quitado del carrito exitosamente."));
    }

    @GetMapping("/contenido")
    public ResponseEntity<List<CursoResponse>> obtenerContenido() {
        Carrito carrito = obtenerCarrito();
        List<CursoResponse> contenido = carrito.getContenido();
        return ResponseEntity.ok(contenido);
    }

    private Carrito obtenerCarrito() {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        return carrito;
    }
    @GetMapping("/contenidoMatricula")
    public ResponseEntity<List<CursoProfesorDTO>> obtenerCursoParaProcesoMatricula() {
        List<CursoProfesorDTO>lista=cursoService.getAllCursosAndProfesores();
        Carrito carrito=obtenerCarrito();
        List<CursoProfesorDTO>returnlista= lista.stream().filter(c -> carrito.getContenido().stream().anyMatch(cr->c.getCurso().getIdcurso()==cr.getId()))
        .collect(Collectors.toList());        
        return ResponseEntity.ok(returnlista);
    }

}
