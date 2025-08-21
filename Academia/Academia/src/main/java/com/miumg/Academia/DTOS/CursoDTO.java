package com.miumg.Academia.DTOS;

public class CursoDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private int profesorId;  // solo el ID del profesor, no toda la entidad
    private String profesorNombre; // opcional, si quieres mostrar también el nombre

    // Constructor
    public CursoDTO(int id, String nombre, String descripcion, int profesorId, String profesorNombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesorId = profesorId;
        this.profesorNombre = profesorNombre;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getProfesorId() { return profesorId; }
    public void setProfesorId(int profesorId) { this.profesorId = profesorId; }

    public String getProfesorNombre() { return profesorNombre; }
    public void setProfesorNombre(String profesorNombre) { this.profesorNombre = profesorNombre; }
}

