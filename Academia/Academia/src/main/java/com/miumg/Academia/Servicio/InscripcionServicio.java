package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miumg.Academia.DTOS.InscripcionDTO;
import com.miumg.Academia.Entidad.Curso;
import com.miumg.Academia.Entidad.Estudiante;
import com.miumg.Academia.Entidad.Inscripcion;
import com.miumg.Academia.Repositorios.RepositorioInscripcion;



@Service
public class InscripcionServicio {

    private final RepositorioInscripcion repositorio;

    public InscripcionServicio(RepositorioInscripcion repositorio) {
        this.repositorio = repositorio;
    }

   
    public List<InscripcionDTO> listar(Integer estudianteId, Integer cursoId) {
        List<Inscripcion> inscripciones;

        if (estudianteId != null && cursoId != null) {
            inscripciones = repositorio.findByEstudianteIdAndCursoId(estudianteId, cursoId);
        } else if (estudianteId != null) {
            inscripciones = repositorio.findByEstudianteId(estudianteId);
        } else if (cursoId != null) {
            inscripciones = repositorio.findByCursoId(cursoId);
        } else {
            inscripciones = repositorio.findAll();
        }

        return inscripciones.stream()
                .map(this::convertirAInscripcionDTO)
                .collect(Collectors.toList());
    }

    public Optional<InscripcionDTO> obtenerPorId(Long id) {
        return repositorio.findById(id)
                .map(this::convertirAInscripcionDTO);
    }

    public InscripcionDTO guardar(Inscripcion inscripcion) {
        Inscripcion guardada = repositorio.save(inscripcion);
        return convertirAInscripcionDTO(guardada);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

 private InscripcionDTO convertirAInscripcionDTO(Inscripcion inscripcion) {
    Estudiante estudiante = inscripcion.getEstudiante();
    Integer estudianteId = (estudiante != null) ? estudiante.getId() : null;
    String estudianteNombre = (estudiante != null) ? estudiante.getNombre() : null;

    Curso curso = inscripcion.getCurso();
    Integer cursoId = (curso != null) ? curso.getId() : null;
    String cursoNombre = (curso != null) ? curso.getNombre() : null;
double nota = Optional.ofNullable(inscripcion.getNota()).orElse(0.0);

return new InscripcionDTO(
    inscripcion.getId(),
    estudianteId,
    estudianteNombre,
    cursoId,
    cursoNombre,
    inscripcion.getFechaInscripcion(),
    nota
);
 }
}