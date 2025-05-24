package com.renan.challengeliteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivros(@JsonAlias("title") String titulo,
                          @JsonAlias("authors") List<DadosAutores> autores,
                          @JsonAlias("languages") List<String> idiomas,
                          @JsonAlias("download_count") Integer downloads) {
}
