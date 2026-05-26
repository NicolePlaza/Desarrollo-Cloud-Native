package com.plataformaeducativa.sistemainscripcion.services;

import com.plataformaeducativa.sistemainscripcion.models.Curso;
import com.plataformaeducativa.sistemainscripcion.repositories.CursoRepository;
import com.plataformaeducativa.sistemainscripcion.models.Inscripcion;
import com.plataformaeducativa.sistemainscripcion.repositories.InscripcionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepository;
    private final CursoRepository cursoRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository, 
                              CursoRepository cursoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.cursoRepository = cursoRepository;
    }

    public Inscripcion inscribirAlumno(List<Long> cursoId, String nombreAlumno) {
        List<Curso> cursos = cursoRepository.findAllById(cursoId);

        if(cursos.isEmpty()){
            throw new IllegalArgumentException("No se encontraron cursos con los IDs proporcionados.");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setNombreAlumno(nombreAlumno);
        inscripcion.setCursos(cursos);
        
        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }


}
