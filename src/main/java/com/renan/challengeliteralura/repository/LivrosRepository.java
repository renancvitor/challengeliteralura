package com.renan.challengeliteralura.repository;

import com.renan.challengeliteralura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
