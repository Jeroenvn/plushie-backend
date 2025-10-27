package dev.jeroen.plushie_backend.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.dtos.AuthDTO;
import dev.jeroen.plushie_backend.dtos.AuthRequestDTO;
import dev.jeroen.plushie_backend.dtos.UserRegisterDTO;
import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.exceptions.IncorrectUsernamePasswordCombinationException;
import dev.jeroen.plushie_backend.exceptions.NotFoundException;
import dev.jeroen.plushie_backend.mappers.UserMapper;
import dev.jeroen.plushie_backend.utilities.JwtUtil;

@Service
public class AuthService {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthService(UserService userService,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public AuthDTO registerUser(UserRegisterDTO userRegister) {
        String rawPassword = userRegister.getPassword();
        String encodedPassword = passwordEncoder.encode(userRegister.getPassword());
        userRegister.setPassword(encodedPassword);
        CustomUser user = UserMapper.INSTANCE.userRegisterDTOToCustomUser(userRegister);
        userService.saveUser(user);
        AuthRequestDTO authRequestDTO = new AuthRequestDTO(userRegister.getUsername(), rawPassword);
        return generateToken(authRequestDTO);
    }

    public AuthDTO registerAdminUser(UserRegisterDTO userRegister) {
        String rawPassword = userRegister.getPassword();
        String encodedPassword = passwordEncoder.encode(userRegister.getPassword());
        userRegister.setPassword(encodedPassword);
        CustomUser user = UserMapper.INSTANCE.userRegisterDTOtoCustomUserAdmin(userRegister);
        userService.saveUser(user);
        AuthRequestDTO authRequestDTO = new AuthRequestDTO(userRegister.getUsername(), rawPassword);
        return generateToken(authRequestDTO);
    }

    public AuthDTO generateToken(AuthRequestDTO authRequest) {
        authRequest.validate();

        if (!userService.existsByUsername(authRequest.getUsername())) {
            throw new NotFoundException("User not found");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword());

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (AuthenticationException e) {
            throw new IncorrectUsernamePasswordCombinationException("Username and password combination is incorrect");
        }

        String token = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
        String tenHours = "36000";

        CustomUser user = userService.getByUsername(authRequest.getUsername());

        AuthDTO authDTO = new AuthDTO(user.getId(), token, tenHours);

        return authDTO;
    }

}
