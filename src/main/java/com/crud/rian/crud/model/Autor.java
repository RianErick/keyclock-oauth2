package com.crud.rian.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "autor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String nome;

    public Autor(String nome, List<Livro> livroSet, Integer quantidadeLivro) {
        this.nome = nome;
        this.livros = livroSet;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "autor",
            fetch = FetchType.LAZY)
    List<Livro> livros;

    public Autor(String nome) {
        this.nome = nome;
    }
}
