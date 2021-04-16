package com.assisjrs.samples.mongo.service;

import java.util.List;
import java.util.ArrayList;

import com.assisjrs.samples.mongo.Entity.Livro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assisjrs.samples.mongo.repository.LivroRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ListarTodosServiceTests {
    @InjectMocks
    private LivroService livroService;

    @Mock
    private LivroRepository livroRepository;

    @Test
    void naoDeveRetonarNuloAoListarLivros() {
        List<?> retornoListarTodos = livroService.listarTodos();
        assertThat(retornoListarTodos).isNotNull();
    }

    @Test
    void deveUsarRepositorioParaListarLivros() {
        livroService.listarTodos();
        verify(livroRepository, atLeastOnce()).findAll();
    }

    @Test
    void deveManterOrdemDeEntradaDeLivros() {
        List<Livro> retornoListarTodos = new ArrayList<>();

        Livro livro1 = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
        retornoListarTodos.add(livro1);

        Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
        retornoListarTodos.add(livro2);

        when(livroRepository.findAll()).thenReturn(retornoListarTodos);

        List<Livro> listaComparacao = new ArrayList<>();
        listaComparacao.add(livro1);
        listaComparacao.add(livro2);

        List<Livro> retornoServiceListarTodos = livroService.listarTodos();
        assertThat(retornoServiceListarTodos).asList().containsAll(listaComparacao);
    }

}
