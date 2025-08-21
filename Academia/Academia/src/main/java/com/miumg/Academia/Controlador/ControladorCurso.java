package com.miumg.Academia.Controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miumg.Academia.DTOS.CursoDTO;
import com.miumg.Academia.Servicio.CursoServicio;

@RestController
@RequestMapping("/cursos")
public class ControladorCurso {

    private final CursoServicio cursoServicio;

    public ControladorCurso(CursoServicio cursoServicio) {
        this.cursoServicio = cursoServicio;
    }

   @GetMapping
public List<CursoDTO> listar(@RequestParam(required = false) String nombre) {
    return cursoServicio.listar(nombre);
}

    // Obtener curso por ID
    @GetMapping("/{id}")
    public CursoDTO obtenerPorId(@PathVariable Integer id) {
        return cursoServicio.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id " + id));
    }
}
