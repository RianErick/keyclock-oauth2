package com.crud.rian.crud.service;

import com.crud.rian.crud.model.Livro;
import com.crud.rian.crud.repo.LivroRepository;
import io.vavr.control.Try;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.vavr.control.Try.run;
@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    @Transactional
    public Livro adicionarLivro(Livro livro) {
        run(() -> livroRepository.save(livro))
                .onFailure(e -> {throw new IllegalArgumentException("Argument Illegal");});
        return livro;
    }
    @Transactional
    public Livro buscarPeloId(Long id){
        return (Livro) run(() -> livroRepository.findById(id).get())
                .onFailure( ex -> {throw  new NoResultException("User not found");
        });
    }
    @Transactional
    public void atualizarLivro(Livro livro , Long id){
       Try<Void> result = Try.of( () -> {
               livro.setId(id);
               livroRepository.save(livro);
                return null;
       });
        result.onFailure(throwable -> {
            throw  new NoResultException("User not found");
        });
     }
     @Transactional
     public void deletarLivro(Long id){
        run(() -> livroRepository.deleteById(id)).onFailure(e -> {
            throw new NoResultException("User not found");
        });
     }
     @Transactional
     public List <Livro> listarLivros(){
        return livroRepository.findAll();
     }
}
