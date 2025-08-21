
package com.miumg.Academia.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miumg.Academia.Entidad.Profesor;


public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {
    List<Profesor> findByNombreContainingIgnoreCase(String nombre);
};