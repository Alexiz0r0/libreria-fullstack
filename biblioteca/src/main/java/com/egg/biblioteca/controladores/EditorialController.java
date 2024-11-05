package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidates.Editorial;
import com.egg.biblioteca.model.dto.EditorialDto;
import com.egg.biblioteca.model.request.EditorialReq;
import com.egg.biblioteca.servicios.EditorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/editoriales")
@CrossOrigin
@RequiredArgsConstructor
public class EditorialController {

    private final EditorialService editorialService;

    @PostMapping
    public Editorial create(@RequestBody EditorialReq editorialReq) {
        Editorial editorial = new Editorial(editorialReq.getNombre());
        return editorialService.agregar(editorial);
    }

    @GetMapping
    public List<Editorial> mostrarEditoriales() {
        return editorialService.listarTodos();
    }

    @GetMapping("/{id}")
    public Editorial encontrarEditorialPorId(@PathVariable String id) {
        return editorialService.encontrarPorId(id);
    }

    @DeleteMapping
    public void eliminareditorial(@RequestBody Editorial editorial) {
        editorialService.eliminar(editorial);
    }

    @PutMapping
    public Editorial modificarEditorial(@RequestBody EditorialDto editorialDto) {
        return editorialService.modificarEditorial(editorialDto);
    }


}
