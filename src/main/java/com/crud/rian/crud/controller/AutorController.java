package com.crud.rian.crud.controller;


import com.crud.rian.crud.model.Autor;
import com.crud.rian.crud.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        "autores"
)
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Autor saveAutor(@RequestBody Autor autor) {
        return autorService.createAutor(autor);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/list-all")
    public List<Autor> listarLisvros() {
        return autorService.listarAutores();
    }


}
