package com.plataformaeducativa.sistemainscripcion.controllers;

import com.plataformaeducativa.sistemainscripcion.models.Curso;
import com.plataformaeducativa.sistemainscripcion.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        Curso nuevo = cursoService.agregarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}
