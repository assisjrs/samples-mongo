package com.assisjrs.samples.mongo.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;

import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class AdicionarLivroControllerTets {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void retornaStatus200AdicionarLivro() {
        webTestClient.post().uri("/livros").exchange().expectStatus().isOk();
    }

    @Test
    void retornaIdAdicionarLivro() {
        webTestClient.post().uri("/livros").exchange().expectBody().jsonPath("$.id").exists();
    }

    @Test
    void retornaTituloAdicionarLivro() {
        webTestClient.post().uri("/livros").exchange().expectBody().jsonPath("$.titulo").exists();
    }
}
