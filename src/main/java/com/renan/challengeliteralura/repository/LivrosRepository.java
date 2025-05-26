package com.renan.challengeliteralura.repository;

import com.renan.challengeliteralura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomasContaining(String idioma);
}
