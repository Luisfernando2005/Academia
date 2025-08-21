package com.miumg.Academia.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miumg.Academia.Entidad.Curso;

public interface RepositorioCurso extends JpaRepository<Curso, Integer> {
    
    List<Curso> findByNombreContainingIgnoreCase(String nombre);
    List<Curso> findByProfesorNombreContainingIgnoreCase(String profesor);

}
