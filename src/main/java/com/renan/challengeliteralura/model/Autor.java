package com.renan.challengeliteralura.model;

public class Autor {
    private String nome;
    private Integer dataNascimento;
    private Integer dataFalecimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(Integer dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getNomeSimples() {
        return nome;
    }


    @Override
    public String toString() {
        return "Autor: " +
                "\nNome: '" + nome + '\'' +
                "\nData de nascimento: " + dataNascimento +
                "\nData de falecimento: " + (dataFalecimento != null ? dataFalecimento : "Ainda vivo");
    }
}
