package it.lucal.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.lucal.app.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
