package com.example.cursomc.resources;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Pedido;
import com.example.cursomc.dto.CategoriaDTO;
import com.example.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.net.URI;

@RestController
@RequestMapping(path ="/pedidos")
public class PedidoResource implements Serializable {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Long id) {
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
