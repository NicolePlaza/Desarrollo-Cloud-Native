package com.plataformaeducativa.sistemainscripcion.repositories;

import com.plataformaeducativa.sistemainscripcion.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
