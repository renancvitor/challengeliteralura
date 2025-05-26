package com.renan.challengeliteralura.services;

import com.renan.challengeliteralura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNome(String nome);
}
