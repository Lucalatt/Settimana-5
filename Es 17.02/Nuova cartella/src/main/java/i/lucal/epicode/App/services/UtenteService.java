package i.lucal.epicode.App.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import i.lucal.epicode.App.entities.Utente;
import i.lucal.epicode.App.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;
	
	 public void saveUtente(Utente u) {
	        utenteRepo.save(u);
	        System.out.println("Utente inserito correttamente!");
	    }
	    
	    public Optional<Utente> getById(int id) {
			return utenteRepo.findById(id);
		}
	    
	    public Utente save(Utente u) {
	    	return utenteRepo.save(u);
	    }
	    
	    public List<Utente> getAll() {
	    	return utenteRepo.findAll();
	    }
	    
	    public Page<Utente> getAll_page(Pageable pageable) {
			return utenteRepo.findAll(pageable);
		}
	    
	    public void delete(Utente u) {
			utenteRepo.delete(u);
		}
}
