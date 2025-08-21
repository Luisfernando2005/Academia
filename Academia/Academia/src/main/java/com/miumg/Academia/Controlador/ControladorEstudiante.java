package com.miumg.Academia.Controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miumg.Academia.DTOS.EstudianteDTO;
import com.miumg.Academia.Servicio.EstudianteServicio;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiante {

    private final EstudianteServicio estudianteServicio;

    public ControladorEstudiante(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

 @GetMapping
public List<EstudianteDTO> listar(@RequestParam(required = false) String nombre) {
    return estudianteServicio.listar(nombre);
}

    @GetMapping("/{id}")
    public EstudianteDTO obtenerPorId(@PathVariable Integer id) {
        return estudianteServicio.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id " + id));
    }
}