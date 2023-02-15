package it.lucal.app;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest
class GestionePrenotazioniApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate rt;
	
	@Test
	public void assertThatTest1MethodContainsWord() throws Exception {
		assertThat(this.rt.getForObject("http://localhost:" + port + "/informativo/it", String.class))
				.contains("prenotazione");
	}

}
