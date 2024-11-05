package com.egg.biblioteca.controladores;

import com.egg.biblioteca.model.dto.LibroDto;
import com.egg.biblioteca.model.request.LibroReq;
import com.egg.biblioteca.model.response.LibroResp;
import com.egg.biblioteca.servicios.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
@CrossOrigin
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @PostMapping
    public LibroResp create(@RequestBody LibroReq libroReq) {
        LibroDto libroDto = LibroDto.builder()
                .isbn(libroReq.getIsbn())
                .titulo(libroReq.getTitulo())
                .ejemplares(libroReq.getEjemplares())
                .idAutor(libroReq.getIdAutor())
                .idEditorial(libroReq.getIdEditorial())
                .build();
        return libroService.agregar(libroDto);
    }

    @GetMapping
    public List<LibroResp> mostrarLibros() {
        return libroService.listarTodos();
    }

    @GetMapping("/{id}")
    public LibroResp econtrarLibroPorId(@PathVariable Long id) {
        return libroService.encontrarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminar(id);
    }

    @PutMapping
    public LibroResp modificarLibro(@RequestBody LibroDto libroDto) {
        return libroService.modificarLibro(libroDto);
    }

}
