package bandtec.ads.fajan.continuada.locadorademidias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("bandtec.ads.fajan.continuada.locadorademidias.controllers")
public class LocadoraDeMidiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraDeMidiasApplication.class, args);
	}

}
