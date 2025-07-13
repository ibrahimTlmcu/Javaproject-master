package com.example.backend.controllers;


import com.example.backend.entity.Talep;

import com.example.backend.services.TalepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/talep")
@CrossOrigin(origins = "http://localhost:4200") // Angular'ın varsayılan portu
public class TalepController {
    @Autowired
    private TalepService talepService;

    @GetMapping
    public List<Talep> getAllTalepler() {
        return talepService.getAllTalepler();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talep> getTalepById(@PathVariable Long id) {
        return talepService.getTalepById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Talep createTalep(@RequestBody Talep talep) {
        return talepService.createTalep(talep);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talep> updateTalep(@PathVariable Long id, @RequestBody Talep talepDetails) {
        return ResponseEntity.ok(talepService.updateTalep(id, talepDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTalep(@PathVariable Long id) {
        talepService.deleteTalep(id);
        return ResponseEntity.noContent().build();
    }
}
