<h1 align="center">:📚 Challenge LiterAlura (<a href="https://www.alura.com.br">Alura</a>) 📖<br>
  <img src="https://img.shields.io/badge/status-Concluído-brightgreen">
</h1>

---

<h2 align="center">✅ Projeto concluído</h2>

Este projeto faz parte da formação **Back-End Java Orientado a Objetos - GB/ONE**, da [Alura](https://www.alura.com.br).

---

<h2 align="center">🌐 API Utilizada</h2>

Este projeto utiliza a [Gutendex](https://gutendex.com/), uma API gratuita que fornece dados completos de livros e seus autores — **sem necessidade de autenticação**.

---

<h2 align="center">📚 Conceitos e Recursos Utilizados</h2>

- Java 17+
- PostgreSQL 16+
- API HTTP (`java.net.http.HttpClient`)
- Deserialização JSON com Jackson
- [Spring Boot](https://start.spring.io/)
- Ferramenta de automação e gerenciamento de projetos: Maven
- Manipulação de registros em Java (`record`)

---

<h2 align="center">🧰 Ferramentas Utilizada</h2>

- 💻 [Eclipse IDE](https://www.eclipse.org/): Ambiente de desenvolvimento integrado.
- 🐘 [PostgreSQL](https://www.postgresql.org/): Sistema de gerenciamento de banco de dados relacional de código aberto.

---

<h2 align="center">📦 Organização do Projeto</h2>

```plaintext
├── com.renan.challengeliteralura
│   ├── dto
│   │    └── AutorDTO
│   ├── main
│   │    └── Main.java                  # Classe principal
│   ├── model
│   │    ├── Autor.java
│   │    ├── Livro.java
│   │    ├── DadosAutores.java          # Record para mapear o JSON da API
│   │    ├── DadosLivros.java
│   │    └── DadosResposta.java
│   ├── repository
│   │    ├── AutorRepository.java
│   │    └── LivroRepository.java
│   ├── service
│   │    ├── ConsumoApi.java
│   │    ├── ConversorDados.java
│   │    └── IConversorDados.java
│   └── ChallengeliteraluraApplication.java
└── README.md
```

---

<h2 align="center">🧮 Funcionalidades</h2>

- Busca em tempo real dos livros via [Gutendex](https://gutendex.com/).
- Opções do sistema:
  - Buscar livro pelo título
  - Listar livros pelo título
  - Listar autores registrados
  - Listar autores vivos em um determinado ano
  - Listar livros em um determinado idioma
- Interface simples via terminal.

---

<h2 align="center">▶️ Como Executar</h2>

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/renancvitor/challengeliteralura.git
   ```
   ```bash
   cd challengeliteralura
   ```
2. **Configure o banco de dados PostgreSQL**:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
3. **Compile e execute**:
- Abra o projeto na sua IDE (ex.: Eclipse).
- Localize a classe `ChallengeliteraluraApplication`.
- Execute como uma aplicação Java.
4. **Siga as instruções no terminal para realizar as operações.**

---

<h2 align="center">📌 Exemplo de Uso</h2>

```text
******************************
Escolha o número de sua opção:
******************************
1. Buscar livro pelo título
2. Listar livros pelo título
3. Listar autores registrados
4. Listar autores vivos em um determinado ano
5. Listar livros em um determinado idioma
0 - Sair

Opção:  2

~*~*~~*~ LIVRO ~*~*~~*~
Título: Dom Casmurro
Autor: Machado de Assis
Idiomas: pt
Downloads: 1543
```
---

<h2 align="center">🔧 Requisitos</h2>

- JDK 17 ou superior
- Acesso à internet (para consultar a API e realizar o download das dependências do Spring Boot)
- PostgresSQL 16 ou superior

---

<h2 align="center">📢 Agradecimento</h2>

Agradeço à [alura](https://www.alura.com.br) por essa oportunidade de aprendizado contínuo e por incentivar o desenvolvimento de habilidades de programação de forma estruturada e desafiadora. 🚀

---

<h2 align="center">🤝 Contribuições</h2>

Se você quiser contribuir para o projeto, siga estas etapas:

1. Faça um fork deste repositório.
2. Crie uma nova branch (`git checkout -b feature/alguma-coisa`).
3. Faça suas mudanças.
4. Envie um pull request explicando as mudanças realizadas.

Obrigado pelo interesse em contribuir!

---

<h2 align="center">📫 Contato</h2>

Se tiver dúvidas ou sugestões, sinta-se à vontade para entrar em contato:

- 📧 **E-mail**: [renan.vitor.cm@gmail.com](mailto:renan.vitor.cm@gmail.com)
- 🐦 **GitHub**: [renancvitor](https://github.com/renancvitor)
- 🟦 **LinkedIn**: [Renan Vitor](https://www.linkedin.com/in/renan-vitor-developer/)

---

<h2 align="center">📄 Licença</h2>

📌 Este projeto é disponibilizado para **fins educacionais e não comerciais**.  
Para uso comercial ou redistribuição, consulte os termos de uso da [Gutendex](https://gutendex.com/).
