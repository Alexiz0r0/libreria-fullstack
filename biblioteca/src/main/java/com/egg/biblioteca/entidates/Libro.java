package com.egg.biblioteca.entidates;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "libro")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    private Long isbn;

    private String titulo;

    private Integer ejemplares;

    @Temporal(TemporalType.DATE)
    private LocalDate alta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

}
