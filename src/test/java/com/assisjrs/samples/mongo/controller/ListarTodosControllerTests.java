package com.assisjrs.samples.mongo.controller;

import com.assisjrs.samples.mongo.Entity.Livro;
import com.assisjrs.samples.mongo.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = DEFINED_PORT)
class ListarTodosControllerTests {
	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private LivroRepository livroRepository;

	@BeforeEach
	void antesDeCadaTesteListarLivros() {
		Livro livro = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
		livroRepository.save(livro);

		Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
		livroRepository.save(livro2);
	}

	@Test
	void retornaStatus200ListarLivros() {
		webTestClient.get().uri("/livros").exchange().expectStatus().isOk();
	}

	@Test
	void retornaIdListarListarLivros() {
		webTestClient.get().uri("/livros").exchange().expectBody().jsonPath("$.[0].id").exists();
	}

	@Test
	void retornaTituloListarLivros() {
		webTestClient.get().uri("/livros").exchange().expectBody().jsonPath("$.[0].titulo").exists();
	}
}
