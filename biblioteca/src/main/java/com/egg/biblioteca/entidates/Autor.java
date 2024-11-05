package com.egg.biblioteca.entidates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "autor")
@Setter
@Getter
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_autor")
    private String id;

    private String nombre;

    public Autor(String nombre) {
        this.nombre = nombre;
    }
}
