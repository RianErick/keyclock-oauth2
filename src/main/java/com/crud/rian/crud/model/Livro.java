package com.crud.rian.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @Size(min = 3 , max = 255)
    @NotBlank
    private String nome;

    @NotBlank
    @Column(name = "capa_url")
    private String capaUrl;

    public Livro(Autor autor, String nome , String capaUrl) {
        this.autor = autor;
        this.nome = nome;
        this.capaUrl = capaUrl;
    }
}
