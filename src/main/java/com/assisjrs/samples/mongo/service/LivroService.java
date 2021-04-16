package com.assisjrs.samples.mongo.service;

import com.assisjrs.samples.mongo.Entity.Livro;
import com.assisjrs.samples.mongo.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }
}
