package i.lucal.epicode.App;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import i.lucal.epicode.App.config.Beans;
import i.lucal.epicode.App.entities.Dispositivo;
import i.lucal.epicode.App.entities.Ruolo;
import i.lucal.epicode.App.entities.StatoDispositivo;
import i.lucal.epicode.App.entities.TipoDispositivo;
import i.lucal.epicode.App.entities.TipoRuolo;
import i.lucal.epicode.App.entities.Utente;
import i.lucal.epicode.App.services.DispositivoService;
import i.lucal.epicode.App.services.RuoloService;
import i.lucal.epicode.App.services.UtenteService;


@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		
	}
	
	@Autowired
	private UtenteService us;
	
	@Autowired
	private RuoloService rl;
	
	@Autowired
	private DispositivoService di;

	private void populateDb() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		Dispositivo d1 = (Dispositivo)ctx.getBean("dispositivo", TipoDispositivo.SMARTPHONE, StatoDispositivo.ASSEGNATO);
		Dispositivo d2 = (Dispositivo)ctx.getBean("dispositivo", TipoDispositivo.LAPTOP, StatoDispositivo.IN_MANUTENZIONE);
		Dispositivo d3 = (Dispositivo)ctx.getBean("dispositivo", TipoDispositivo.TABLET, StatoDispositivo.DISPONIBILE);
		Utente u1 = (Utente)ctx.getBean("utente", "Mario", "Rossi", "mrossi", "m@rossi", "Mr123");
		Utente u2 = (Utente)ctx.getBean("utente", "Giovanni", "Verdi", "gverdi", "g@verdi", "Gv456");
		Ruolo r1 = (Ruolo)ctx.getBean("ruolo", TipoRuolo.RUOLO_ADMIN);
		Ruolo r2 = (Ruolo)ctx.getBean("ruolo", TipoRuolo.RUOLO_USER);
		
		u1.setRuoli(new HashSet<>() {{
			add(r1);
		}});
		u2.setRuoli(new HashSet<>() {{
			add(r2);
		}});
		
		u1.setDispositivi(new HashSet<>() {{
			add(d1);
		}});
	

		di.saveDispositivo(d1);
		di.saveDispositivo(d2);
		di.saveDispositivo(d3);
		rl.saveRuolo(r1);
		rl.saveRuolo(r2);
		us.saveUtente(u1);
		us.saveUtente(u2);
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//populateDb();
	}
	
	private void getRolesFromUserById(int id) {
		Optional<Utente> authUserObj = us.getById(id);
		Utente authUser = authUserObj.get();
		String role = "USER";
		Set<Ruolo> ruoli = authUser.getRuoli();
		
		for( Ruolo r : ruoli ) {
			if( r.getTipoR().toString().contains("ADMIN") ) {
				role = "ADMIN";
				break;
			}
		}
		
		System.out.println(role);
	}
}
