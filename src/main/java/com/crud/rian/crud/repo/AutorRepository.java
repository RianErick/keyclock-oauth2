package com.crud.rian.crud.repo;

import com.crud.rian.crud.model.Autor;
import com.crud.rian.crud.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {

}
