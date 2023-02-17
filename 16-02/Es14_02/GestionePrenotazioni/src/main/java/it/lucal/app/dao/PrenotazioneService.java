package it.lucal.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.lucal.app.entity.Postazione;
import it.lucal.app.entity.Prenotazione;

@Service
public class PrenotazioneService {
	
	@Autowired
    private PrenotazioneRepository prenotazioneRepo;

    public void insertPrenotazione(Prenotazione pre) {
        prenotazioneRepo.save(pre);
        System.out.println("Prenotazione inserita correttamente!");
    }
    public long getCountPrenotazioni(LocalDate data, int id) {
    	return prenotazioneRepo.getCountPrenotazioni(data,id);
    }
    public long getCountPrenotazioniUtente(LocalDate data, int id) {
    	return prenotazioneRepo.getCountPrenotazioniUtente(data,id);
    }
    
    public Optional<Prenotazione> getById(int id) {
		return prenotazioneRepo.findById(id);
	}
    
    public Prenotazione save(Prenotazione p) {
    	return prenotazioneRepo.save(p);
    }
    
    public List<Prenotazione> getAll() {
    	return prenotazioneRepo.findAll();
    }
    
    public Page<Prenotazione> getAll_page(Pageable pageable) {
		return prenotazioneRepo.findAll(pageable);
	}
    
    public void delete(Prenotazione p) {
		prenotazioneRepo.delete(p);
	}

}