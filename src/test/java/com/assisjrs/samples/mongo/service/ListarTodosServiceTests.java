package com.assisjrs.samples.mongo.service;

import com.assisjrs.samples.mongo.Entity.Livro;
import com.assisjrs.samples.mongo.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@SpringBootTest
public class ListarTodosServiceTests {
    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    @BeforeEach
    void antesDeCadaTeste() {
        Livro livro = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
        livroRepository.save(livro);

        Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
        livroRepository.save(livro2);
    }

    @Test
    void deveRetornarListaDeLivrosDoBanco() {
        List<Livro> livros = livroService.listarTodos();
        assertThat(livros).isNotEmpty();
    }

    @Test
    void deveConterSegundoLivroDaLista() {
        List<Livro> livros = livroService.listarTodos();
        assertThat(livros.get(1)).isEqualTo(new Livro("2", "Senhor Dos aneis : As Duas Torres"));
    }
}
