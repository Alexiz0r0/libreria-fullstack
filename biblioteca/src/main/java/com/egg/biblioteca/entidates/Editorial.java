package com.egg.biblioteca.entidates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "editorial")
@Setter
@Getter
@NoArgsConstructor
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_editorial")
    private String id;

    private String nombre;

    public Editorial(String nombre) {
        this.nombre = nombre;
    }
}
