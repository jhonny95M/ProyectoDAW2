package com.cibertec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "profesor_curso")
public class ProfesorCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idestado",foreignKey = @ForeignKey(name = "none"))
    private Estado estado;

    // Otros atributos y relaciones

    @ManyToOne
    @JoinColumn(name = "profesor_id",foreignKey = @ForeignKey(name = "none"))
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "curso_id",foreignKey = @ForeignKey(name = "none"))
    private Curso curso;
    
    @OneToMany(mappedBy = "profesorCurso", cascade = CascadeType.ALL)
    private List<Horario> horarios = new ArrayList<>();

    // Constructor, getters y setters
}
