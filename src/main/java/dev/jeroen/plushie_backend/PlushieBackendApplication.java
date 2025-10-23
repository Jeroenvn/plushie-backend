package dev.jeroen.plushie_backend;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.repositories.ProductRepository;

@SpringBootApplication
public class PlushieBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlushieBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductRepository repository) {
		return args -> {
			Product product = new Product();
			product.setName("Red Shrimp Large");
			product.setDescription("Large plushie of a red shrimp.");

			repository.save(product);
			Product saved = repository.findById(product.getId()).orElseThrow(NoSuchElementException::new);
			System.out.println(saved.toString());

		};
	}
}
