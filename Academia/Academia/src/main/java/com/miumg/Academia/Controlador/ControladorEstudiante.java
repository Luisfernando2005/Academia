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

import com.miumg.Academia.Entidad.Estudiante;
import com.miumg.Academia.Servicio.EstudianteServicio;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiante {

    private final EstudianteServicio servicio;

    public ControladorEstudiante(EstudianteServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return servicio.guardar(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return servicio.guardar(estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
