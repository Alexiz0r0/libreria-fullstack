package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidates.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
}
