package br.itmnon.itmnon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itmnon.itmnon.model.Alarme;
import br.itmnon.itmnon.repository.AlarmeRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AlarmeController {
    
    @Autowired
    private AlarmeRepo alarmeRepo;

    @PostMapping("/all")
    public ResponseEntity<List<Alarme>> buscarTodos() {
        List<Alarme> lista = (List<Alarme>) alarmeRepo.findAll();

        return ResponseEntity.ok(lista);
    }
}
