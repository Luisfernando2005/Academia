package com.miumg.Academia.Controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miumg.Academia.DTOS.InscripcionDTO;
import com.miumg.Academia.Servicio.InscripcionServicio;

@RestController
@RequestMapping("/inscripciones")
public class ControladorInscripcion {

    private final InscripcionServicio servicio;

    public ControladorInscripcion(InscripcionServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<InscripcionDTO> listar(
            @RequestParam(required = false) Integer estudianteId,
            @RequestParam(required = false) Integer cursoId) {
        return servicio.listar(estudianteId, cursoId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
