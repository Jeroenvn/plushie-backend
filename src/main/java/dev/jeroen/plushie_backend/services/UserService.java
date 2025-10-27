package dev.jeroen.plushie_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.exceptions.CustomRuntimeException;
import dev.jeroen.plushie_backend.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = getByUsername(username);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }

    public void saveUser(CustomUser user) {
        if (existsByUsername(user.getUsername())) {
            throw new CustomRuntimeException("Username must be unique", HttpStatus.BAD_REQUEST);
        }
        repository.save(user);
    }

    public CustomUser getByUsername(String username) {
        Optional<CustomUser> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new CustomRuntimeException("User not found", HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public CustomUser getById(Long id) {
        Optional<CustomUser> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new CustomRuntimeException("User not found", HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

    public ArrayList<CustomUser> getAll() {
        return repository.findAll();
    }

}
