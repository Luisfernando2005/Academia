package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miumg.Academia.Entidad.Estudiante;
import com.miumg.Academia.Repositorios.RepositorioEstudiante;

@Service
public class EstudianteServicio {

    private final RepositorioEstudiante repositorio;

    public EstudianteServicio(RepositorioEstudiante repositorio) {
        this.repositorio = repositorio;
    }

    public List<Estudiante> listar() {
        return repositorio.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
