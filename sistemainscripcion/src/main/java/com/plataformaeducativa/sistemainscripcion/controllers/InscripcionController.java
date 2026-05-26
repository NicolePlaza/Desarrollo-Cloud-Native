package com.plataformaeducativa.sistemainscripcion.controllers;

import com.plataformaeducativa.sistemainscripcion.models.Curso;
import com.plataformaeducativa.sistemainscripcion.models.Inscripcion;
import com.plataformaeducativa.sistemainscripcion.services.InscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    
    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @PostMapping
    public ResponseEntity<Inscripcion> inscribirAlumno(@RequestBody Inscripcion request) {
        try {
            Inscripcion nuevaInscripcion = inscripcionService.inscribirAlumno(request.getCursos().stream().map(Curso::getId).toList(), request.getNombreAlumno());
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaInscripcion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Inscripcion>> listarInscripciones() {
        return ResponseEntity.ok(inscripcionService.listarInscripciones());
    }
}
