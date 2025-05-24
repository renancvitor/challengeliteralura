package com.renan.challengeliteralura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int status = response.statusCode();
            if (status == 200) {
                return response.body();
            } else {
                System.out.println("Erro na requisição. Código HTTP: " + status);
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na requisição: " + e.getMessage());
            return null;
        }
    }
}
