package i.lucal.epicode.App.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import i.lucal.epicode.App.entities.Dispositivo;
import i.lucal.epicode.App.entities.Ruolo;
import i.lucal.epicode.App.entities.Utente;
import i.lucal.epicode.App.repositories.DispositivoRepository;
import i.lucal.epicode.App.repositories.RuoloRepository;

@Service
public class RuoloService {
	
	@Autowired
	private RuoloRepository ruoloRepo;
	
	public Ruolo saveRuolo(Ruolo rl) {
		return ruoloRepo.save(rl);
	}
	
	 public Optional<Ruolo> getById(int id) {
			return ruoloRepo.findById(id);
		}
	    
	    public Ruolo save(Ruolo rl) {
	    	return ruoloRepo.save(rl);
	    }
	    
	    public List<Ruolo> getAll() {
	    	return ruoloRepo.findAll();
	    }
	    
	    public Page<Ruolo> getAll_page(Pageable pageable) {
			return ruoloRepo.findAll(pageable);
		}
	    
	    public void delete(Ruolo rl) {
	    	ruoloRepo.delete(rl);
		}

}
