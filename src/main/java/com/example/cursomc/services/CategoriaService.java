package com.example.cursomc.services;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Long id) {
        Categoria obj = repository.findById(id).get();
        return obj;
    }

//    public Categoria findById(Long id) {
//        Categoria cat = new Categoria(1L, "Teste 1");
//        Categoria cat2 = new Categoria(2L, "Teste 2");
//
//        repository.save(cat);
//        repository.save(cat2);
//
//        Categoria obj = repository.findById(id).get();
//        return obj;
//    }
}
