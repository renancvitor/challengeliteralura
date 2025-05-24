package com.renan.challengeliteralura.main;

import com.renan.challengeliteralura.model.DadosLivros;
import com.renan.challengeliteralura.model.DadosResposta;
import com.renan.challengeliteralura.model.Livro;
import com.renan.challengeliteralura.services.ConsumoApi;
import com.renan.challengeliteralura.services.ConverteDados;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    private final String ENDERECO = "https://gutendex.com/books?search=";

    private List<DadosLivros> dadosLivros = new ArrayList<>();

    // private LivrosRepository repository;

    private Optional<Livro> livroBusca;

    // public Main(LivroRepository repository) {
    //     this.repository = repository;
    // }

    public void menu() throws IOException {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n******************************
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
                    System.out.println("Sessão encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private DadosLivros getDadosLivrows() {
        System.out.print("Digite o nome do livro para buscar: ");
        var nomeLivro = scanner.nextLine();

        try {
            String nomeLivroEncoded = URLEncoder.encode(nomeLivro, StandardCharsets.UTF_8);
            var json = consumoApi.obterDados(ENDERECO + nomeLivroEncoded);

            if (json == null || json.isBlank()) {
                System.out.println("Resposta da API vazia.");
                return null;
            }

            DadosResposta resposta = converteDados.obterDados(json, DadosResposta.class);

            if (resposta != null && resposta.results() != null && !resposta.results().isEmpty()) {
                return resposta.results().get(0);
            } else {
                System.out.println("Nenhum livro encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados: " + e.getMessage());
            return null;
        }
    }

    private void buscarLivro() throws IOException {
        DadosLivros dados = getDadosLivrows();
        Livro livro = new Livro(dados);
//        repository.save(livro);
        System.out.println(livro);
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
