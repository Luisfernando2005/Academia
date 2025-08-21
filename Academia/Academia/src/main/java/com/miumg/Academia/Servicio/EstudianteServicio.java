package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miumg.Academia.DTOS.EstudianteDTO;
import com.miumg.Academia.Entidad.Estudiante;
import com.miumg.Academia.Repositorios.RepositorioEstudiante;

@Service
public class EstudianteServicio {

    private final RepositorioEstudiante repositorio;

    public EstudianteServicio(RepositorioEstudiante repositorio) {
        this.repositorio = repositorio;
    }

   
    public List<EstudianteDTO> listar(String nombreFiltro) {
        List<Estudiante> estudiantes;

        if (nombreFiltro != null && !nombreFiltro.isEmpty()) {
            estudiantes = repositorio.findByNombreContainingIgnoreCase(nombreFiltro);
        } else {
            estudiantes = repositorio.findAll();
        }

        return estudiantes.stream()
                .map(this::convertirAEstudianteDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> obtenerPorId(Integer id) {
        return repositorio.findById(id)
                .map(this::convertirAEstudianteDTO);
    }

    public EstudianteDTO guardar(Estudiante estudiante) {
        Estudiante guardado = repositorio.save(estudiante);
        return convertirAEstudianteDTO(guardado);
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }

    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        return new EstudianteDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getEmail()
        );
    }
}
