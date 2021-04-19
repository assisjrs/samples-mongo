package com.assisjrs.samples.mongo.controller;

import com.assisjrs.samples.mongo.Entity.Livro;
import com.assisjrs.samples.mongo.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listarTodos() {
        List<Livro> livros = livroService.listarTodos();

        List<LivroResponse> listLivros = new ArrayList<>();

        for (Livro livro: livros) {
            LivroResponse livroResponse = new LivroResponse();
            livroResponse.setId(livro.getId());
            livroResponse.setTitulo(livro.getTitulo());
            listLivros.add(livroResponse);
        }

        return ResponseEntity.ok(listLivros);
    }

    @PostMapping
    public ResponseEntity<?> adicionarLivro() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
