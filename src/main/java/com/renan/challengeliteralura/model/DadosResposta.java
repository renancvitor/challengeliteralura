package com.renan.challengeliteralura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResposta(
        int count,
        String next,
        String previous,
        List<DadosLivros> results
) { }
