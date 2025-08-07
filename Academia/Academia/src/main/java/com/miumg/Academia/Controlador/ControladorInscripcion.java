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

import com.miumg.Academia.Entidad.Inscripcion;
import com.miumg.Academia.Servicio.InscripcionServicio;

@RestController
@RequestMapping("/inscripciones")
public class ControladorInscripcion {

    private final InscripcionServicio servicio;

    public ControladorInscripcion(InscripcionServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Inscripcion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Inscripcion> obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Inscripcion crear(@RequestBody Inscripcion inscripcion) {
        return servicio.guardar(inscripcion);
    }

    @PutMapping("/{id}")
    public Inscripcion actualizar(@PathVariable Integer id, @RequestBody Inscripcion inscripcion) {
        inscripcion.setId(id);
        return servicio.guardar(inscripcion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
