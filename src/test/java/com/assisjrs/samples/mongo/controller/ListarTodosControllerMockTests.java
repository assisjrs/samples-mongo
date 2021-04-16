package com.assisjrs.samples.mongo.controller;

import com.assisjrs.samples.mongo.Entity.Livro;
import com.assisjrs.samples.mongo.service.LivroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListarTodosControllerMockTests {
    @InjectMocks
    private LivroController livroController;

    @Mock
    private LivroService livroService;

    @Test
    void deveUsarServiceParaListarLivros(){
        livroController.listarTodos();
        verify(livroService, atLeastOnce()).listarTodos();
    }

    @Test
    void deveManterOrdemDeEntradaDeLivros() {
        List<Livro> retornoListarTodos = new ArrayList<>();

        Livro livro1 = new Livro("1", "Senhor Dos aneis : A Sociedade do Anel");
        retornoListarTodos.add(livro1);

        Livro livro2 = new Livro("2", "Senhor Dos aneis : As Duas Torres");
        retornoListarTodos.add(livro2);

        when(livroService.listarTodos()).thenReturn(retornoListarTodos);

        List<LivroResponse> listaComparacao = new ArrayList<>();
        listaComparacao.add(new LivroResponse(livro1.getId(), livro1.getTitulo()));
        listaComparacao.add(new LivroResponse(livro2.getId(), livro2.getTitulo()));

        ResponseEntity<List<LivroResponse>> retornoControllerListarTodos = livroController.listarTodos();
        assertThat(retornoControllerListarTodos.getBody()).asList().containsAll(listaComparacao);
    }

}
