package com.miumg.Academia.Servicio;

import org.springframework.stereotype.Service;

import com.miumg.Academia.Entidad.Curso;
import com.miumg.Academia.Repositorios.RepositorioCurso;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    private final RepositorioCurso repositorio;

    public CursoServicio(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public List<Curso> listar() {
        return repositorio.findAll();
    }

    public Optional<Curso> obtenerPorId(Integer id) {
        return repositorio.findById(id);
    }

    public Curso guardar(Curso curso) {
        return repositorio.save(curso);
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}