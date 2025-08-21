package com.miumg.Academia.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miumg.Academia.DTOS.CursoDTO;
import com.miumg.Academia.Entidad.Curso;
import com.miumg.Academia.Repositorios.RepositorioCurso;

@Service
public class CursoServicio {

    private final RepositorioCurso repositorio;

    public CursoServicio(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    // LISTAR CON FILTRO OPCIONAL POR NOMBRE
    public List<CursoDTO> listar(String nombreFiltro) {
        List<Curso> cursos;

        if (nombreFiltro != null && !nombreFiltro.isEmpty()) {
            cursos = repositorio.findByNombreContainingIgnoreCase(nombreFiltro);
        } else {
            cursos = repositorio.findAll();
        }

        return cursos.stream()
                .map(this::convertirACursoDTO)
                .collect(Collectors.toList());
    }

    public Optional<CursoDTO> obtenerPorId(Integer id) {
        return repositorio.findById(id)
                .map(this::convertirACursoDTO);
    }

    public CursoDTO guardar(Curso curso) {
        Curso guardado = repositorio.save(curso);
        return convertirACursoDTO(guardado);
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }

    private CursoDTO convertirACursoDTO(Curso curso) {
        var profesor = curso.getProfesor();
        Integer profesorIdObj = (profesor != null) ? profesor.getId() : null;
        int profesorId = (profesorIdObj != null) ? profesorIdObj : 0;
        String profesorNombre = (profesor != null) ? profesor.getNombre() : null;
        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                profesorId,
                profesorNombre
        );
    }
}
