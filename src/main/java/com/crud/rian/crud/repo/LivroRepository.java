package com.crud.rian.crud.repo;

import com.crud.rian.crud.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
