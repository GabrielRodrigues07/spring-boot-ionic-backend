package com.example.cursomc.services;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.services.exceptions.DataIntegrityException;
import com.example.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria find(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(find(id).getId());
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um categoria que possui Produtos.");
        }
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
