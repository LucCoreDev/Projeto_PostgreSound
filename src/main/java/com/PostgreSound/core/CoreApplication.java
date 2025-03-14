package com.PostgreSound.core;

import com.PostgreSound.core.principal.Aplicacao;
import com.PostgreSound.core.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication implements CommandLineRunner {

	@Autowired
	private Repositorio repositorio;


	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        var aplicacao = new Aplicacao(repositorio);
		aplicacao.Menu();
	}
}
