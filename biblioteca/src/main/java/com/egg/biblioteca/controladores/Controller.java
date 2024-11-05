package com.egg.biblioteca.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello/{name}")
    public void insert(@PathVariable("name") String name) {
        System.out.println("Hello " + name);
    }
}
