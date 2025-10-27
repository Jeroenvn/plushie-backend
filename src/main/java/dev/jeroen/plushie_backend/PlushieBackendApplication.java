package dev.jeroen.plushie_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.jeroen.plushie_backend.dtos.AuthDTO;
import dev.jeroen.plushie_backend.dtos.UserRegisterDTO;
import dev.jeroen.plushie_backend.services.AuthService;

@SpringBootApplication
public class PlushieBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlushieBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthService authService) {
		return args -> {

			UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
			userRegisterDTO.setUsername("supersecretusername");
			userRegisterDTO.setPassword("supersecretpassword");

			AuthDTO authDTO = authService.registerAdminUser(userRegisterDTO);

			System.out.println(authDTO.getToken());

		};
	}
}
