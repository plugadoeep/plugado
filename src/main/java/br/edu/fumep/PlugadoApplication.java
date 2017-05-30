package br.edu.fumep;

import br.edu.fumep.service.storage.StorageProperties;
import br.edu.fumep.service.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PlugadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlugadoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
