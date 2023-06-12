package com.cibertec.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.cibertec.response.CursoResponse;

public class Carrito {
	private List<CursoResponse> contenido;

    public Carrito() {
        this.contenido = new ArrayList<>();
    }

    public void agregarProducto(CursoResponse curso) {
        contenido.add(curso);
    }

    public void eliminarProducto(Long idCurso) {
        contenido.removeIf(p -> p.getId().equals(idCurso));
    }

    public List<CursoResponse> getContenido() {
        return contenido;
    }

}
