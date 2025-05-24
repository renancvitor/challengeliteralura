package com.renan.challengeliteralura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Autor {
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    private List<Livro> livros = new ArrayList<>();

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
        return "\nAutor: '" + nome + '\'' +
               "\nData de nascimento: " + anoNascimento +
               "\nData de falecimento: " + (anoFalecimento != null ? anoFalecimento : "Ainda vivo") +
               "\nLivros: " + livrosString;
    }
}
