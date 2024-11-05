package br.edu.infnet.paulojansen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.edu.infnet.paulojansen.model.repository")
public class PaulojansenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaulojansenApplication.class, args);
	}

}
