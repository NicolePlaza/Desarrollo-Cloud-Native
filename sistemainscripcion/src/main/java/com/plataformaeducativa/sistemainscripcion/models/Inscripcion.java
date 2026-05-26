package com.plataformaeducativa.sistemainscripcion.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_seq")
    @SequenceGenerator(name = "inscripcion_seq", sequenceName = "INSCRIPCION_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nombreAlumno;

    @Column(nullable = false)
    private LocalDateTime fechaInscripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "INSCRIPCION_CURSOS",
        joinColumns = @JoinColumn(name = "inscripcion_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    @Column(nullable = false)
    private Double costoTotal;


    @PrePersist
    public void prePersist() {
        this.fechaInscripcion = LocalDateTime.now();
        if(this.cursos != null && !this.cursos.isEmpty()) {
            this.costoTotal = this.cursos.stream().mapToDouble(Curso::getCosto).sum();
        } else {
            this.costoTotal = 0.0;
        }
    }
}
