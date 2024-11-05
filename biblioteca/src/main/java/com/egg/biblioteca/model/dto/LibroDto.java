package com.egg.biblioteca.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDto {

    private Long isbn;

    private String titulo;

    private Integer ejemplares;

    private String idAutor;

    private String idEditorial;
}
