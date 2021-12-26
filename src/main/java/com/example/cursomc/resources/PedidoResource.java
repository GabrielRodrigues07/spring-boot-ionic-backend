package com.example.cursomc.resources;

import com.example.cursomc.domain.Cliente;
import com.example.cursomc.domain.Pedido;
import com.example.cursomc.services.ClienteService;
import com.example.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(path ="/pedidos")
public class PedidoResource implements Serializable {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Long id) {
        Pedido obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
