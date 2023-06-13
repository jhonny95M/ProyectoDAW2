package com.cibertec.api.controller;

import java.util.List;

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

import com.cibertec.response.CursoResponse;
import com.cibertec.response.OkResponse;
import com.cibertec.viewmodel.Carrito;

@RestController
@RequestMapping("/api/cart")
public class ApiCarritoController {
	
	@Autowired
    private HttpSession session;

    @PostMapping("/agregar")
    public ResponseEntity<OkResponse> agregarProducto(@RequestBody CursoResponse curso) throws ValidationException {
        Carrito carrito = obtenerCarrito();
        if(carrito.getContenido().stream().anyMatch(c->c.getId()==curso.getId()))
        	throw new ValidationException("Ya fue agregado el curso "+curso.getNomcurso()+".");
        carrito.agregarProducto(curso);
        return ResponseEntity.ok(new OkResponse("Curso agregado exitosamente."));
    }

    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<OkResponse> eliminarProducto(@PathVariable Long idCurso) {
        Carrito carrito = obtenerCarrito();
        carrito.eliminarProducto(idCurso);
        return ResponseEntity.ok(new OkResponse("El curso fue eliminado exitosamente."));
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

}
