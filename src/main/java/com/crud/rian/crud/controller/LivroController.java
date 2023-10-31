package com.crud.rian.crud.controller;

import com.crud.rian.crud.model.Livro;
import com.crud.rian.crud.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*") //Corss
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro adicionarLivro(@RequestBody Livro livro){
      return  livroService.adicionarLivro(livro);
    }

    @GetMapping("/list-all")
    public List<Livro> listarLisvros (){
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id){
        return livroService.buscarPeloId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
         livroService.deletarLivro(id);
    }

    @PutMapping("/edit/{id}")
    public void atualizarLivro(@RequestBody Livro livro ,  @PathVariable Long id ){
        livroService.atualizarLivro(livro,id);
    }
}
