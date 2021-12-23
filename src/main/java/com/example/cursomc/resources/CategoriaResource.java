package com.example.cursomc.resources;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
