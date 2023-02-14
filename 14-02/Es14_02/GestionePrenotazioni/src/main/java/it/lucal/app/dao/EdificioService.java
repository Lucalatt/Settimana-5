package it.lucal.app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lucal.app.entity.Edificio;

@Service
public class EdificioService {
	
	@Autowired
    private EdificioRepository edificioRepo;

    public void insertEdificio(Edificio e) {
        edificioRepo.save(e);
        System.out.println("Edificio inserito correttamente!");
    }
    
    public Optional<Edificio> getById(int id) {
		return edificioRepo.findById(id);
	}

}
