package com.assisjrs.samples.mongo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = DEFINED_PORT)
class ListarTodosTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void retornaStatus200() {
		webTestClient.get().uri("/livros").exchange().expectStatus().isOk();
	}

	@Test
	void retornaId() {
		webTestClient.get().uri("/livros").exchange().expectBody().jsonPath("$.[0].id").exists();
	}

	@Test
	void retornaTitulo() {
		webTestClient.get().uri("/livros").exchange().expectBody().jsonPath("$.[0].titulo").exists();
	}

}
