package com.renan.challengeliteralura.model;

import com.renan.challengeliteralura.dto.AutorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {}

//    public Autor(DadosLivros dadosLivros) {
//        this.nome = dadosLivros.autores().get(0).nome();
//        this.anoNascimento = dadosLivros.autores().get(0).anoNascimento();
//        this.anoFalecimento = dadosLivros.autores().get(0).anoFalecimento();
//    }

    public Autor(String nome) {
        this.nome = nome;
    }

    public Autor(AutorDTO autorDTO) {
        this.nome = autorDTO.nome();
        this.anoNascimento = autorDTO.anoNascimento();
        this.anoFalecimento = autorDTO.anoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNomeSimples() {
        return nome;
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public String toString() {
        String livrosString = livros.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.joining(", "));

        return "\nAutor: " + nome +
               "\nData de nascimento: " + anoNascimento +
               "\nData de falecimento: " + (anoFalecimento != null ? anoFalecimento : "Ainda vivo") +
               "\nLivros: " + livrosString;
    }
}
