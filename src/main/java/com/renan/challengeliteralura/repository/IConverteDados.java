package com.renan.challengeliteralura.repository;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
