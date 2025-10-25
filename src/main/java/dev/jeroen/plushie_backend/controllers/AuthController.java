package dev.jeroen.plushie_backend.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeroen.plushie_backend.dtos.AuthDTO;
import dev.jeroen.plushie_backend.dtos.AuthRequestDTO;
import dev.jeroen.plushie_backend.dtos.UserRegisterDTO;
import dev.jeroen.plushie_backend.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/newUser")
    public ResponseEntity<AuthDTO> registerUser(@RequestBody UserRegisterDTO userRegister) {
        AuthDTO authDTO = authService.registerUser(userRegister);
        return ResponseEntity.ok(authDTO);
    }

    @PostMapping("/generateToken")
    public ResponseEntity<AuthDTO> generateToken(@RequestBody AuthRequestDTO authRequest) {
        AuthDTO authDTO = authService.generateToken(authRequest);
        return ResponseEntity.ok(authDTO);
    }

}
