package com.miumg.Academia.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miumg.Academia.Entidad.Curso;
import com.miumg.Academia.Servicio.CursoServicio;

@RestController
@RequestMapping("/cursos")
public class ControladorCurso {

    private final CursoServicio servicio;

    public ControladorCurso(CursoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Curso> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Curso> obtener(@PathVariable Integer id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return servicio.guardar(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        curso.setId(id);
        return servicio.guardar(curso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
    }
}