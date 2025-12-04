package dev.jeroen.plushie_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.jeroen.plushie_backend.dtos.AuthDTO;
import dev.jeroen.plushie_backend.dtos.CategoryCreateDTO;
import dev.jeroen.plushie_backend.dtos.ProductCreateDTO;
import dev.jeroen.plushie_backend.dtos.UserRegisterDTO;
import dev.jeroen.plushie_backend.services.AuthService;
import dev.jeroen.plushie_backend.services.CategoryService;
import dev.jeroen.plushie_backend.services.ProductService;

@SpringBootApplication
public class PlushieBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlushieBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthService authService, CategoryService categoryService, ProductService productService) {
		return args -> {

			UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
			userRegisterDTO.setUsername("supersecretusername");
			userRegisterDTO.setPassword("supersecretpassword");
			authService.registerAdminUser(userRegisterDTO);

			CategoryCreateDTO cat = new CategoryCreateDTO();
			cat.setName("Sea Creatures");
			categoryService.createCategory(cat);

			CategoryCreateDTO cat2 = new CategoryCreateDTO();
			cat2.setName("Land Creatures");
			categoryService.createCategory(cat2);

			CategoryCreateDTO cat3 = new CategoryCreateDTO();
			cat3.setName("Air Creatures");
			categoryService.createCategory(cat3);

			ProductCreateDTO product1 = new ProductCreateDTO();
			product1.setCategory_id(1L);
			product1.setName("Large Red Shrimp");
			product1.setDescription("A Large red Shrimp");

			productService.createProduct(product1);

			ProductCreateDTO product2 = new ProductCreateDTO();
			product2.setCategory_id(1L);
			product2.setName("Medium Red Shrimp");
			product2.setDescription("A Medium red Shrimp");

			productService.createProduct(product2);

			ProductCreateDTO product3 = new ProductCreateDTO();
			product3.setCategory_id(1L);
			product3.setName("Small Red Shrimp");
			product3.setDescription("A Small red Shrimp");

			productService.createProduct(product3);

			ProductCreateDTO product4 = new ProductCreateDTO();
			product4.setCategory_id(1L);
			product4.setName("Large Blue Shrimp");
			product4.setDescription("A Large Blue Shrimp");

			productService.createProduct(product4);

			ProductCreateDTO product5 = new ProductCreateDTO();
			product5.setCategory_id(1L);
			product5.setName("Medium Blue Shrimp");
			product5.setDescription("A Medium Blue Shrimp");

			productService.createProduct(product5);

			ProductCreateDTO product6 = new ProductCreateDTO();
			product6.setCategory_id(1L);
			product6.setName("Small Blue Shrimp");
			product6.setDescription("A Small Blue Shrimp");

			productService.createProduct(product6);

			ProductCreateDTO product7 = new ProductCreateDTO();
			product7.setCategory_id(1L);
			product7.setName("Large purple Shrimp");
			product7.setDescription("A Large purple Shrimp");

			productService.createProduct(product7);

			ProductCreateDTO product8 = new ProductCreateDTO();
			product8.setCategory_id(1L);
			product8.setName("Medium purple Shrimp");
			product8.setDescription("A Medium purple Shrimp");

			productService.createProduct(product8);

			ProductCreateDTO product9 = new ProductCreateDTO();
			product9.setCategory_id(1L);
			product9.setName("Small purple Shrimp");
			product9.setDescription("A Small purple Shrimp");

			productService.createProduct(product9);

			ProductCreateDTO product10 = new ProductCreateDTO();
			product10.setCategory_id(1L);
			product10.setName("Lobster");
			product10.setDescription("A Lobster plushie");

			productService.createProduct(product10);

		};
	}
}
