package com.egg.biblioteca.servicios.impl;

import com.egg.biblioteca.entidates.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.model.dto.AutorDto;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.servicios.AutorService;
import com.egg.biblioteca.util.StringValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServicioImpl implements AutorService {

    private final AutorRepositorio autorRepositorio;

    @Override
    public List<Autor> listarTodos() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor agregar(Autor autor) {
        StringValidator.isValid(autor.getNombre());
        return autorRepositorio.save(autor);
    }

    @Override
    public Autor encontrarPorId(String id) {
        return isAutorPresent(id);
    }

    @Override
    public void eliminar(Autor autor) {
        Autor autor1 = isAutorPresent(autor.getId());
        autorRepositorio.delete(autor1);
    }

    @Override
    public Autor modificarAutor(AutorDto autorDto) {
        Autor autor = isAutorPresent(autorDto.getId());
        autor.setNombre(autorDto.getNombre());
        return agregar(autor);
    }

    private Autor isAutorPresent(String id) {
        Autor autor = autorRepositorio.findById(id).orElse(null);
        if (autor == null) {
            throw new MiException("El recurso no existe");
        }
        return autor;
    }
}
