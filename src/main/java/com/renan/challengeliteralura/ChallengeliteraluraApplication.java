package com.renan.challengeliteralura;

import com.renan.challengeliteralura.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeliteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeliteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main principal = new Main();
		principal.menu();
	}
}
