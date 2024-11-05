package com.egg.biblioteca.servicios.impl;

import com.egg.biblioteca.entidates.Autor;
import com.egg.biblioteca.entidates.Editorial;
import com.egg.biblioteca.entidates.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.model.dto.LibroDto;
import com.egg.biblioteca.model.response.LibroResp;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import com.egg.biblioteca.servicios.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServicioImpl implements LibroService {

    private final LibroRepositorio libroRepositorio;
    private final AutorRepositorio autorRepositorio;
    private final EditorialRepositorio editorialRepositorio;

    @Override
    public List<LibroResp> listarTodos() {
        List<Libro> libros = libroRepositorio.findAll();
        List<LibroResp> respList = new ArrayList<>();
        for (Libro libro : libros) {
            respList.add(generateLibro(libro));
        }
        return respList;
    }

    @Override
    public LibroResp agregar(LibroDto libro) {
        Autor autor = isAutorPresent(libro.getIdAutor());

        Editorial editorial = isEditorialPresent(libro.getIdEditorial());

        Libro libro1 = new Libro();
        libro1.setIsbn(libro.getIsbn());
        libro1.setTitulo(libro.getTitulo());
        libro1.setEjemplares(libro.getEjemplares());
        libro1.setAutor(autor);
        libro1.setEditorial(editorial);
        libro1.setAlta(LocalDate.now());
        return generateLibro(libroRepositorio.save(libro1));
    }

    @Override
    public LibroResp encontrarPorId(Long id) {
        return generateLibro(isLibroPresent(id));
    }

    @Override
    public void eliminar(Long id) {
        Libro libro = isLibroPresent(id);
        libroRepositorio.delete(libro);
    }

    @Override
    public LibroResp modificarLibro(LibroDto libroDto) {

        if (libroDto.getIsbn() == null) {
            throw new MiException("el campo ISBN debe ser nulo");
        }

        Libro libro = isLibroPresent(libroDto.getIsbn());
        Autor autor = isAutorPresent(libroDto.getIdAutor());
        Editorial editorial = isEditorialPresent(libroDto.getIdEditorial());

        libro.setTitulo(libroDto.getTitulo());
        libro.setEjemplares(libroDto.getEjemplares());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        return generateLibro(libroRepositorio.save(libro));
    }

    public Libro isLibroPresent(Long id) {
        Libro libro = libroRepositorio.findById(id).orElse(null);
        if (libro == null) {
            throw new MiException("El recurso Libro no existe");
        }
        return libro;
    }

    public Autor isAutorPresent(String id) {
        Autor autor = autorRepositorio.findById(id).orElse(null);
        if (autor == null) {
            throw new MiException("El recurso Autor no existe");
        }
        return autor;
    }

    public Editorial isEditorialPresent(String id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial == null) {
            throw new MiException("El recurso Editorial no existe");
        }
        return editorial;
    }

    public LibroResp generateLibro(Libro libro) {

        return LibroResp.builder()
                .isbn(libro.getIsbn())
                .titulo(libro.getTitulo())
                .ejemplares(libro.getEjemplares())
                .idAutor(libro.getAutor().getId())
                .nombreAutor(libro.getAutor().getNombre())
                .idEditorial(libro.getEditorial().getId())
                .nombreEditorial(libro.getEditorial().getNombre())
                .build();
    }

}
