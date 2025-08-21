package com.miumg.Academia.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miumg.Academia.Entidad.Estudiante;

public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer> {
    
    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
}