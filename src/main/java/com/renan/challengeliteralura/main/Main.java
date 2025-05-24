package com.renan.challengeliteralura.main;

import com.renan.challengeliteralura.services.ConsumoApi;
import com.renan.challengeliteralura.services.ConverteDados;

import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    private final String URL = "https://gutendex.com/books?search=";

    public void menu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    ******************************
                    Escolha o número de sua opção:
                    ******************************
                    1. Buscar livro pelo título
                    2. Listar livro pelo título
                    3. Listar autores registrados
                    4. Listar autores vivos em um determinado ano
                    5. Listar livros em um determinado idioma
                                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivro();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosPorXAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivro() {
    }

    private void listarLivro() {
    }

    private void listarAutores() {
    }

    private void listarAutoresVivosPorXAno() {
    }

    private void listarLivrosPorIdioma() {
    }
}
