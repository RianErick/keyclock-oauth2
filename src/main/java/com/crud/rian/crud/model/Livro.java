package com.crud.rian.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "livro")
@Builder
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3 , max = 255)
    private String autor;

    @Size(min = 3 , max = 255)
    @NotBlank
    private String nome;

    public Livro(String autor, String nome) {
        this.autor = autor;
        this.nome = nome;
    }
}
