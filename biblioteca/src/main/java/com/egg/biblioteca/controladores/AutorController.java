package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidates.Autor;
import com.egg.biblioteca.model.dto.AutorDto;
import com.egg.biblioteca.model.request.AutorReq;
import com.egg.biblioteca.servicios.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autores")
@CrossOrigin
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public Autor create(@RequestBody AutorReq autorReq) {
        Autor autor = new Autor(autorReq.getNombre());
        return autorService.agregar(autor);
    }

    @GetMapping
    public List<Autor> mostrarAutores() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Autor encontrarAutorPorId(@PathVariable String id) {
        return autorService.encontrarPorId(id);
    }

    @DeleteMapping
    public void eliminarAutor(@RequestBody Autor autor) {
        autorService.eliminar(autor);
    }

    @PutMapping
    public Autor modificarAutor(@RequestBody AutorDto autorDto) {
        return autorService.modificarAutor(autorDto);
    }
}
