package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miumg.Academia.Entidad.Inscripcion;
import com.miumg.Academia.Repositorios.RepositorioInscripcion;

@Service
public class InscripcionServicio {

    private final RepositorioInscripcion repositorio;

    public InscripcionServicio(RepositorioInscripcion repositorio) {
        this.repositorio = repositorio;
    }

    public List<Inscripcion> listar() {
        return repositorio.findAll();
    }

    public Optional<Inscripcion> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Inscripcion guardar(Inscripcion inscripcion) {
        return repositorio.save(inscripcion);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}