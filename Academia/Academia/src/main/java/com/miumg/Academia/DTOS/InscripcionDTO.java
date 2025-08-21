package com.miumg.Academia.DTOS;

import java.time.LocalDate;

public class InscripcionDTO {
    private int id;
    private int estudianteId;
    private String estudianteNombre; // opcional, si quieres mostrar el nombre
    private int cursoId;
    private String cursoNombre; // opcional
    private LocalDate fechaInscripcion;
    private double nota;

    // Constructor
    public InscripcionDTO(int id, int estudianteId, String estudianteNombre, int cursoId, String cursoNombre,
            LocalDate fechaInscripcion, double nota) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.estudianteNombre = estudianteNombre;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.fechaInscripcion = fechaInscripcion;
        this.nota = nota;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
