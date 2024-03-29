package com.bytecode.startcms.controller.rest;


import com.bytecode.startcms.model.Contenido;
import com.bytecode.startcms.model.common.RepBase;
import com.bytecode.startcms.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contenido")
public class ContenidoRestController {

    @Autowired
    private ContenidoRepository repository;

    @PutMapping
    public ResponseEntity<RepBase> save(@RequestBody Contenido contenido){
        return ResponseEntity.ok(new RepBase(repository.save(contenido)));
    }

    @PostMapping
    public ResponseEntity<RepBase> update(@RequestBody Contenido contenido){
        return ResponseEntity.ok(new RepBase(repository.update(contenido)));
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> findAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> findById(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id));
    }

}
