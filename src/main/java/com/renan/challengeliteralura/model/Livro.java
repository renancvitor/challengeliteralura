package com.renan.challengeliteralura.model;

import java.util.List;
import java.util.stream.Collectors;

public class Livro {
    private String titulo;
    private List<Autor> autores;
    private List<String> idiomas;
    private Integer downloads;

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
        String autoresStr = autores.stream()
                .map(Autor::toString)
                .collect(Collectors.joining("\n"));
        return "Livro: " +
                "\nTítulo: '" + titulo + '\'' +
                "\nAutor: " + autoresStr  +
                "\nIdiomas: " + idiomas +
                "\nDownloads: " + downloads;
    }
}
