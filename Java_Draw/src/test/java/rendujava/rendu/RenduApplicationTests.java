package rendujava.rendu;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import rendujava.rendu.Model.Dessin;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RenduApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@DisplayName("DESSIN CONTROLER : CREATION DESSIN http://localhost:<port>/dessin?id=1")
	@Test
	public void TestRecupDessin() throws JSONException {
		String url = String.format("http://localhost:%1$s/dessin?id=1", port);
		System.out.println("Recup :" + url);
		ResponseEntity<Dessin> response = restTemplate.getForEntity(url, Dessin.class);
		Dessin dessin = new Dessin();
		dessin.setId(1);
		dessin.setWidth(5);
		dessin.setHeight(5);
		dessin.setName("Hello");
		dessin.setDescription("Hello World");

		Assertions.assertEquals(dessin.toString(), response.getBody().toString());
	}

}
