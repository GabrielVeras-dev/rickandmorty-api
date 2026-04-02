package com.gabrielveras.rickandmorty_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// @EnableCaching habilita o sistema de cache do Spring
// Os métodos anotados com @Cacheable passam a armazenar resultados em memória
@SpringBootApplication
@EnableCaching
public class RickandmortyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickandmortyApiApplication.class, args);
	}
}