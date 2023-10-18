package com.crud.rian.crud.config;

import com.crud.rian.crud.model.Livro;
import com.crud.rian.crud.repo.LivroRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;


@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner commandLineRunner(LivroRepository livroRepository) {
        return args -> {
            log.info("Preloading " + livroRepository.save(new Livro("Ricardo Lemos", "As Aventuras de PI")));
            log.info("Preloading " + livroRepository.save(new Livro("J.K. Rowling", "Harry Potter and the Philosopher's Stone")));
            log.info("Preloading " + livroRepository.save(new Livro("Harper Lee", "To Kill a Mockingbird")));
            log.info("Preloading " + livroRepository.save(new Livro("Jane Austen", "Pride and Prejudice")));
            log.info("Preloading " + livroRepository.save(new Livro("F. Scott Fitzgerald", "The Great Gatsby")));

        };
    }
}
