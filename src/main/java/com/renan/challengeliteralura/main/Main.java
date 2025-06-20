package com.renan.challengeliteralura.main;

import com.renan.challengeliteralura.dto.AutorDTO;
import com.renan.challengeliteralura.model.Autor;
import com.renan.challengeliteralura.dto.DadosLivros;
import com.renan.challengeliteralura.dto.DadosResposta;
import com.renan.challengeliteralura.model.Livro;
import com.renan.challengeliteralura.repository.LivrosRepository;
import com.renan.challengeliteralura.repository.AutorRepository;
import com.renan.challengeliteralura.services.ConsumoApi;
import com.renan.challengeliteralura.services.ConverteDados;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    private final String ENDERECO = "https://gutendex.com/books?search=";

    private List<DadosLivros> dadosLivros = new ArrayList<>();

    private LivrosRepository livrosRepository;
    private AutorRepository autorRepository;

    private Optional<Livro> livroBusca;

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();

    public Main(AutorRepository autorRepository, LivrosRepository livrosRepository) {
         this.autorRepository = autorRepository;
         this.livrosRepository = livrosRepository;
    }

    public void menu() throws IOException {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n******************************
                    Escolha o número de sua opção:
                    ******************************
                    1. Buscar livro pelo título
                    2. Listar livros pelo título
                    3. Listar autores registrados
                    4. Listar autores vivos em um determinado ano
                    5. Listar livros em um determinado idioma
                    0 - Sair
                    """;

            System.out.println(menu);
            System.out.print("Opção:  ");
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
        DadosLivros dadosLivros = getDadosLivrows();

        AutorDTO autorDTO = dadosLivros.autores().get(0);
        String nomeAutor = autorDTO.nome();

        List<Autor> autores = autorRepository.findByNome(nomeAutor);
        Autor autor = autores.isEmpty() ? null : autores.get(0);

        if (autor == null) {
            autor = new Autor(autorDTO);
            autorRepository.save(autor);
        }

        Livro livro = new Livro(dadosLivros);
        livro.setAutor(autor);
        autor.getLivros().add(livro);

        livrosRepository.save(livro);

        System.out.println(livro);
    }

    private void listarLivro() {
        livros = livrosRepository.findAll();
        livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .forEach(System.out::println);
    }

    private void listarAutores() {
        autores = autorRepository.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autor::getNome))
                .forEach(System.out::println);
    }

    private void listarAutoresVivosPorXAno() {
        System.out.print("Digite o ano para verificar quais autores estavam vivos:  ");
        var anoConsulta = scanner.nextInt();
        scanner.nextLine();

        autorRepository.findAutoresVivosNoAno(anoConsulta)
                .forEach(System.out::println);
    }

    private void listarLivrosPorIdioma() {
        var menuIdioma = """
        \nEscolha a sigla do idioma que deseja buscar os livros
        en - Inglês
        es - Espanhol
        fr - Franês
        pt - Português
        """;
        System.out.println(menuIdioma);

        System.out.print("Digite a sigla do idioma:  ");
        String idiomaEscolhido = scanner.nextLine().trim().toLowerCase();

        List<Livro> livrosPorIdioma = livrosRepository.findByIdiomasContaining(idiomaEscolhido);

        if (livrosPorIdioma.isEmpty()) {
            System.out.println("\nNenhum livro encontrado para o idioma: " + idiomaEscolhido);
        } else {
            System.out.println("\nLivros no idioma \"" + idiomaEscolhido + "\":");
            livrosPorIdioma.stream()
                    .sorted(Comparator.comparing(Livro::getTitulo))
                    .forEach(System.out::println);
        }
    }
}
