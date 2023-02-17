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
import i.lucal.epicode.App.repositories.UtenteRepository;

@Service
public class DispositivoService {
	@Autowired
	private DispositivoRepository dispositivoRepo;

	public Dispositivo saveDispositivo(Dispositivo di) {
		return dispositivoRepo.save(di);
	}
	
	public Optional<Dispositivo> getById(int id) {
		return dispositivoRepo.findById(id);
	}

	public Dispositivo save(Dispositivo d) {
		return dispositivoRepo.save(d);
	}

	public List<Dispositivo> getAll() {
		return dispositivoRepo.findAll();
	}

	public Page<Dispositivo> getAll_page(Pageable pageable) {
		return dispositivoRepo.findAll(pageable);
	}

	public void delete(Dispositivo d) {
		dispositivoRepo.delete(d);
	}

}
