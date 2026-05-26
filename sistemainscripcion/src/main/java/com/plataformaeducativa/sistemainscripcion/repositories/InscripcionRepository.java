package com.plataformaeducativa.sistemainscripcion.repositories;

import com.plataformaeducativa.sistemainscripcion.models.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    
}
