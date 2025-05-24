package com.renan.challengeliteralura.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
