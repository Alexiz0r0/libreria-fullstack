package com.egg.biblioteca.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroReq {
    private Long isbn;

    private String titulo;

    private Integer ejemplares;

    private String idAutor;

    private String idEditorial;
}
