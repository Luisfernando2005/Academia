package com.miumg.Academia.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miumg.Academia.Entidad.Inscripcion;

public interface RepositorioInscripcion extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByEstudianteId(Integer estudianteId);
    List<Inscripcion> findByCursoId(Integer cursoId);
    List<Inscripcion> findByEstudianteIdAndCursoId(Integer estudianteId, Integer cursoId);

}