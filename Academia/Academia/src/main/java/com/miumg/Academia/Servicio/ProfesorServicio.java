package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miumg.Academia.DTOS.ProfesorDTO;
import com.miumg.Academia.Entidad.Profesor;
import com.miumg.Academia.Repositorios.ProfesorRepositorio;

@Service
public class ProfesorServicio {

    private final ProfesorRepositorio repositorio;

    public ProfesorServicio(ProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // LISTAR CON FILTRO OPCIONAL POR NOMBRE
    public List<ProfesorDTO> listar(String nombreFiltro) {
        List<Profesor> profesores;

        if (nombreFiltro != null && !nombreFiltro.isEmpty()) {
            profesores = repositorio.findByNombreContainingIgnoreCase(nombreFiltro);
        } else {
            profesores = repositorio.findAll();
        }

        return profesores.stream()
                .map(this::convertirAProfesorDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfesorDTO> obtenerPorId(Integer id) {
        return repositorio.findById(id)
                .map(this::convertirAProfesorDTO);
    }

    public ProfesorDTO guardar(Profesor profesor) {
        Profesor guardado = repositorio.save(profesor);
        return convertirAProfesorDTO(guardado);
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }

    private ProfesorDTO convertirAProfesorDTO(Profesor profesor) {
        return new ProfesorDTO(
                profesor.getId(),
                profesor.getNombre(),
                profesor.getEspecialidad()
        );
    }
}
