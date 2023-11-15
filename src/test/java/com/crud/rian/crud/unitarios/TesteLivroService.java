package com.crud.rian.crud.unitarios;

import com.crud.rian.crud.CrudApplication;
import com.crud.rian.crud.model.Livro;
import com.crud.rian.crud.repo.LivroRepository;
import com.crud.rian.crud.service.LivroService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = CrudApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteLivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroService livroService;

    @Test
    @Order(1)
    public void getById() {
        Livro livro = livroRepository.findById(1L).get();
        Assertions.assertThat(livro.getId()).isEqualTo(1L);
    }

    @Test
    @Order(2)
    public void update() {
        Livro livro = livroRepository.findById(1L).get();
        Livro livro1 = Livro.builder().id(livro.getId()).nome("Dom Casmurro").autor("Machado de Assis").build();
        livroService.atualizarLivro(livro1, livro1.getId());
        Assertions.assertThat(livro1.getId().equals(1L));
        Assertions.assertThat(livro1.getNome().equals("Dom Casmurro"));
        Assertions.assertThat(livro1.getAutor().equals("Machado de Assis"));
    }

    @Test
    @Order(3)
    public void delete() {
        Livro livro1 = Livro.builder().id(2L).nome("Dom Casmurro").autor("Machado de Assis").build();
        livroService.deletarLivro(livro1.getId());
        Assertions.assertThat(livroRepository.findById(2L).isEmpty());
    }

    @Test
    @Order(4)
    public void create() {
        Livro livroContexto = Livro.builder().id(2L).nome("Clean Code").autor("Uncle Bob").build();
        livroService.adicionarLivro(livroContexto);
        Assertions.assertThat(livroRepository.findById(2L).isPresent());
    }

    @Test
    @Order(5)
    public void listAll() {
        List<Livro> livros = livroService.listarLivros();
        Assertions.assertThat(livros.size()).isEqualTo(5L);
    }
}
