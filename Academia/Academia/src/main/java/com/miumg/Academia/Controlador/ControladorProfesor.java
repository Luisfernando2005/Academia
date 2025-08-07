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

import com.miumg.Academia.Entidad.Profesor;
import com.miumg.Academia.Servicio.ProfesorServicio;

@RestController
@RequestMapping("/profesores")
public class ControladorProfesor {

    private final ProfesorServicio servicio;

    public ControladorProfesor(ProfesorServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Profesor> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Profesor> obtener(@PathVariable Integer id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return servicio.guardar(profesor);
    }

    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Integer id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        return servicio.guardar(profesor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
    }
}