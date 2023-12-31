package com.crud.rian.crud.service;

import com.crud.rian.crud.model.Autor;
import com.crud.rian.crud.model.Livro;
import com.crud.rian.crud.repo.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.vavr.control.Try.run;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    @Transactional
    public Autor createAutor(Autor autor){
        run( () -> autorRepository.saveAndFlush(autor))
                .onFailure(ex -> { new IllegalArgumentException(ex.getMessage());});  return autor;
    }
    @Transactional
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }


}
