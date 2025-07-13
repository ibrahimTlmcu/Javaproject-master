package com.example.backend.services;

import com.example.backend.entity.Talep;
import com.example.backend.repositories.TalepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalepService {

    @Autowired
    private TalepRepository talepRepository;

    // Tüm talepleri getir
    public List<Talep> getAllTalepler() {
        return talepRepository.findAll();
    }

    // ID'ye göre tek talep getir
    public Optional<Talep> getTalepById(Long id) {
        return talepRepository.findById(id);
    }

    // Yeni talep oluştur
    public Talep createTalep(Talep talep) {
        return talepRepository.save(talep);
    }

    // Talebi güncelle
    public Talep updateTalep(Long id, Talep talepDetails) {
        Talep talep = talepRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Talep bulunamadı, ID: " + id));

        talep.setAdSoyad(talepDetails.getAdSoyad());
        talep.setEmail(talepDetails.getEmail());
        talep.setKonu(talepDetails.getKonu());
        talep.setAciklama(talepDetails.getAciklama());
        talep.setKategori(talepDetails.getKategori());

        return talepRepository.save(talep);
    }

    // Talep silme işlemi
    public void deleteTalep(Long id) {
        if (!talepRepository.existsById(id)) {
            throw new RuntimeException("Silinecek talep bulunamadı, ID: " + id);
        }
        talepRepository.deleteById(id);
    }
}
