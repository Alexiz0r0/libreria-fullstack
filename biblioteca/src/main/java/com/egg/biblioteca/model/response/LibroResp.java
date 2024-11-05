package com.egg.biblioteca.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroResp {
    private Long isbn;

    private String titulo;

    private Integer ejemplares;

    private String idAutor;

    private String nombreAutor;

    private String idEditorial;

    private String nombreEditorial;
}
