package br.itmnon.itmnon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itmnon.itmnon.model.Evento;
import br.itmnon.itmnon.repository.EventoRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EventoController {

    @Autowired
    private EventoRepo eventRepo;
    
        @GetMapping("/all")
        public ResponseEntity<List<Evento>> buscarTodos() {
            List<Evento> lista = (List<Evento>) eventRepo.findAll();
    
            return ResponseEntity.ok(lista);
        }


/*         DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Date ini = Date.parse(json.get("dt1").asText(), fmt);
		Date fim = Date.parse(json.get("dt2").asText(), fmt);

        List<Evento> eventos = eventRepo.findByStartDateBetween(dt1, dt2);

        @GetMapping("/periodo")
        public ResponseEntity<List<Evento>> buscarTodos() {
            List<Evento> lista = (List<Evento>) eventRepo.findAll();
    
            
            return ResponseEntity.ok(lista);
} */
        
    }