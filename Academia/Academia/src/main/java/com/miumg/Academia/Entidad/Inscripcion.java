package com.miumg.Academia.Entidad;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Estudiante estudiante;

    @ManyToOne(optional = false)
    private Curso curso;

    private LocalDate fechaInscripcion = LocalDate.now();

    private Double nota;

    public Inscripcion() {}

    public Inscripcion(Integer id, Estudiante estudiante, Curso curso, LocalDate fechaInscripcion, Double nota) {
        this.id = id;
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = fechaInscripcion;
        this.nota = nota;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public Double getNota() { return nota; }
    public void setNota(Double nota) { this.nota = nota; }
}
