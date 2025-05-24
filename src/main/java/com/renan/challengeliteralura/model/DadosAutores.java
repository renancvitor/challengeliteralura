package com.renan.challengeliteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutores(@JsonAlias("name") String nome,
                           @JsonAlias("birth_year") Integer dataNascimento,
                           @JsonAlias("death_year") Integer dataFalecimento) {
}
