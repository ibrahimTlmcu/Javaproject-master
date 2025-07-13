package com.example.backend.controllers;

import com.example.backend.entity.Faq;
import com.example.backend.entity.Kategori;
import com.example.backend.services.FaqService;
import com.example.backend.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kategori")
@CrossOrigin(origins = "http://localhost:4200") // Angular'ın varsayılan portu
public class KategoriController {
    @Autowired
    private KategoriService kategoriService;

    @GetMapping
    public List<Kategori> getAllFaqs() {
        return kategoriService.getAllKategori();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kategori> getByIdKategori(@PathVariable Long id) {
        return kategoriService.getKategoriById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Kategori createKategori(@RequestBody Kategori kategori) {
        return kategoriService.createKategori(kategori);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kategori> updateKategori(@PathVariable Long id, @RequestBody Kategori kategoriDetails) {
        return ResponseEntity.ok(kategoriService.updateKategori(id, kategoriDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKategori(@PathVariable Long id) {
        kategoriService.deleterKategori(id);
        return ResponseEntity.noContent().build();
    }
}