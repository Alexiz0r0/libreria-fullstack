package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidates.Libro;
import com.egg.biblioteca.model.dto.LibroDto;
import com.egg.biblioteca.model.response.LibroResp;

import java.util.List;

public interface LibroService {

    List<LibroResp> listarTodos();

    LibroResp agregar(LibroDto libro);

    LibroResp encontrarPorId(Long id);

    void eliminar(Long id);

    LibroResp modificarLibro(LibroDto libroDto);
}
