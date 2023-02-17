package i.lucal.epicode.App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



import i.lucal.epicode.App.entities.Dispositivo;
import i.lucal.epicode.App.entities.Ruolo;
import i.lucal.epicode.App.entities.StatoDispositivo;
import i.lucal.epicode.App.entities.TipoDispositivo;
import i.lucal.epicode.App.entities.TipoRuolo;
import i.lucal.epicode.App.entities.Utente;

@Configuration
public class Beans {

	@Bean
	@Scope("prototype")
	public Utente utente(String nome, String cognome, String username, String email, String password) {
		return Utente.builder()
				.nome(nome)
				.cognome(cognome)
				.username(username)
				.email(email)
				.password(password)
				.active(true)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Ruolo ruolo(TipoRuolo tr) {
		return Ruolo.builder()
				.tipoR(tr)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Dispositivo dispositivo(TipoDispositivo td, StatoDispositivo sd) {
		return Dispositivo.builder()
				.stato(sd)
				.tipoD(td)
				.build();
	}
	
}
