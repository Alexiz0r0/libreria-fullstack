package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidates.Autor;
import com.egg.biblioteca.entidates.Libro;
import com.egg.biblioteca.model.dto.AutorDto;

import java.util.List;

public interface AutorService {

    List<Autor> listarTodos();

    Autor agregar(Autor autor);

    Autor encontrarPorId(String id);

    void eliminar(Autor autor);

    Autor modificarAutor(AutorDto autorDto);
}
