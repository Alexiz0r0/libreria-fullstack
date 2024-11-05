package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidates.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.model.dto.EditorialDto;

import java.util.List;

public interface EditorialService {

    List<Editorial> listarTodos();

    Editorial agregar(Editorial editorial);

    Editorial encontrarPorId(String id);

    void eliminar(Editorial editorial);

    Editorial modificarEditorial(EditorialDto editorialDto);
}
