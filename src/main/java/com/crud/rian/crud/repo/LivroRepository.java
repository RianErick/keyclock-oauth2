package com.crud.rian.crud.repo;

import com.crud.rian.crud.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
