package com.renan.challengeliteralura.model;

import java.util.List;
import java.util.stream.Collectors;

public class Livro {
    private String titulo;
    private List<Autor> autores;
    private List<String> idiomas;
    private Integer downloads;

    public Livro(DadosLivros dadosLivros) {
        this.titulo = dadosLivros.titulo();
        this.autores = dadosLivros.autores().stream()
                .map(a -> {
                    Autor autor = new Autor();
                    autor.setNome(a.nome());
                    return autor;
                })
                .collect(Collectors.toList());
        this.idiomas = dadosLivros.idiomas();
        this.downloads = dadosLivros.downloads();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        String autoresString = autores.stream()
                .map(Autor::getNomeSimples)
                .collect(Collectors.joining("\n"));
        String idiomasSring = idiomas.stream()
                .map(String::toString)
                .collect(Collectors.joining("\n"));
        return "\n~*~*~~*~ LIVRO ~*~*~~*~" +
                "\nTítulo: " + titulo +
                "\nAutor: " + autoresString  +
                "\nIdiomas: " + idiomasSring +
                "\nDownloads: " + downloads;
    }
}
