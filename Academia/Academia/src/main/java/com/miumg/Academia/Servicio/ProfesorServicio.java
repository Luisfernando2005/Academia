package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miumg.Academia.Entidad.Profesor;
import com.miumg.Academia.Repositorios.ProfesorRepositorio;

@Service
public class ProfesorServicio {

    private final ProfesorRepositorio repositorio;

    public ProfesorServicio(ProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Profesor> listar() {
        return repositorio.findAll();
    }

    public Optional<Profesor> obtenerPorId(Integer id) {
        return repositorio.findById(id);
    }

    public Profesor guardar(Profesor profesor) {
        return repositorio.save(profesor);
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}
