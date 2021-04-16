package com.assisjrs.samples.mongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<LivroResponse> listLivros = new ArrayList<>();

        LivroResponse livroResponse = new LivroResponse();
        livroResponse.setId("1");
        livroResponse.setTitulo("Senhor dos Aneis");

        listLivros.add(livroResponse);

        return ResponseEntity.ok(listLivros);
    }
}
