package com.renan.challengeliteralura.services;

import com.renan.challengeliteralura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
