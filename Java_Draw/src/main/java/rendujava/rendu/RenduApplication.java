package rendujava.rendu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rendujava.rendu.Model.Dessin;
import rendujava.rendu.Repository.DessinRepository;

@SpringBootApplication
public class RenduApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenduApplication.class, args);
	}
	@Bean
	public CommandLineRunner LoadData(DessinRepository repo) {
		return (args) -> {
			Dessin image = new Dessin(1, 5, 5, "Hello", "Hello World");
			Dessin image2 = new Dessin(2, 10, 10, "Bonjour", "Bonjour le monde");
			Dessin image3 = new Dessin(3, 15, 15, "Hola", "Hola ninos");
			Dessin image4 = new Dessin(4, 20, 20, "Merci", "Y'a pas de quoi");
			repo.save(image);
			repo.save(image2);
			repo.save(image3);
			repo.save(image4);
		};
	}
}
