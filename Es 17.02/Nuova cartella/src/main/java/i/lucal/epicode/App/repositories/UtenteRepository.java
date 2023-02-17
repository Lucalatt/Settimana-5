package i.lucal.epicode.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import i.lucal.epicode.App.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
