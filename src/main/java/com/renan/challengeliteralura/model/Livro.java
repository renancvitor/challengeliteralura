package com.renan.challengeliteralura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    private Autor autor;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "livro_idiomas", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "idioma")
    private List<String> idiomas = new ArrayList<>();
    private Integer downloads;

    public Livro() {}

    public Livro(DadosLivros dadosLivros) {
        this.titulo = dadosLivros.titulo();
        this.autor = dadosLivros.autor();
//        this.autor = dadosLivros.autor().stream()
//                .map(a -> {
//                    Autor autor = new Autor();
//                    autor.setNome(a.nome());
//                    autor.adicionarLivro(this);
//                    return autor;
//                })
//                .collect(Collectors.toList());
        this.idiomas = dadosLivros.idiomas();
        this.downloads = dadosLivros.downloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getautor() {
        return autor;
    }

    public void setautor(Autor autor) {
        this.autor = autor;
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
//        String autorString = autor.stream()
//                .map(Autor::getNomeSimples)
//                .collect(Collectors.joining("\n"));

        String idiomasString = idiomas.stream()
                .map(String::toString)
                .collect(Collectors.joining("\n"));

        return "\n~*~*~~*~ LIVRO ~*~*~~*~" +
               "\nTítulo: " + titulo +
               "\nAutor: " + autor.getNome()  +
               "\nIdiomas: " + idiomasString +
               "\nDownloads: " + downloads;
    }
}
