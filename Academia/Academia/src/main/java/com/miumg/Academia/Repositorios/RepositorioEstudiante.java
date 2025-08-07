package com.miumg.Academia.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miumg.Academia.Entidad.Estudiante;

public interface RepositorioEstudiante extends JpaRepository<Estudiante, Long> {}