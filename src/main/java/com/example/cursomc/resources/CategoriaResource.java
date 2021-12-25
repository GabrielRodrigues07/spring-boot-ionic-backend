package com.example.cursomc.resources;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Optional;

@RestController
@RequestMapping(path ="/categorias")
public class CategoriaResource implements Serializable {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Long id) {
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

//    @GetMapping(path = "/{id}")
//    public ResponseEntity findByid(@PathVariable Long id) {
//        Categoria obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }

}
