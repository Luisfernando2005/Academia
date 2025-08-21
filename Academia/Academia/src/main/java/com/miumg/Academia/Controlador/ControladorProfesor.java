package com.miumg.Academia.Controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miumg.Academia.DTOS.ProfesorDTO;
import com.miumg.Academia.Servicio.ProfesorServicio;

@RestController
@RequestMapping("/profesores")
public class ControladorProfesor {

    private final ProfesorServicio servicio;

    public ControladorProfesor(ProfesorServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<ProfesorDTO> listar(@RequestParam(required = false) String especialidad) {
        return servicio.listar(especialidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerPorId(@PathVariable Integer id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
