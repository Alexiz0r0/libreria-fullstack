package com.egg.biblioteca.servicios.impl;

import com.egg.biblioteca.entidates.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.model.dto.EditorialDto;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.servicios.EditorialService;
import com.egg.biblioteca.util.StringValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialServicioImpl implements EditorialService {

    private final EditorialRepositorio editorialRepositorio;

    @Override
    public List<Editorial> listarTodos() {
        return editorialRepositorio.findAll();
    }

    @Override
    public Editorial agregar(Editorial editorial) {
        StringValidator.isValid(editorial.getNombre());
        return editorialRepositorio.save(editorial);
    }

    @Override
    public Editorial encontrarPorId(String id) {
        return isEditorialPresent(id);
    }

    @Override
    public void eliminar(Editorial editorial) {
        Editorial editorial1 = isEditorialPresent(editorial.getId());
        editorialRepositorio.delete(editorial1);
    }

    @Override
    public Editorial modificarEditorial(EditorialDto editorialDto) {
        Editorial editorial = isEditorialPresent(editorialDto.getId());
        editorial.setNombre(editorialDto.getNombre());
        return agregar(editorial);
    }

    private Editorial isEditorialPresent(String id) {
        Editorial editorial = editorialRepositorio.findById(id).orElse(null);
        if (editorial == null) {
            throw new MiException("El recurso no existe");
        }
        return editorial;
    }
}
