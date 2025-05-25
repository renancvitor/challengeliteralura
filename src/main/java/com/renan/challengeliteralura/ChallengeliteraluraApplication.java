package com.renan.challengeliteralura;

import com.renan.challengeliteralura.main.Main;
import com.renan.challengeliteralura.repository.LivrosRepository;
import com.renan.challengeliteralura.services.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeliteraluraApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LivrosRepository livrosRepository;


	public static void main(String[] args) {
		SpringApplication.run(ChallengeliteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main principal = new Main(autorRepository, livrosRepository);
		principal.menu();
	}
}
