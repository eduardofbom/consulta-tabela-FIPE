package br.com.eduardofbom.consulta_tabela_FIPE;

import br.com.eduardofbom.consulta_tabela_FIPE.principal.Principal;
import br.com.eduardofbom.consulta_tabela_FIPE.service.ApiConsumption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaTabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaTabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showMenu();
	}
}
