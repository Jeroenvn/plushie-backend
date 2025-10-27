package dev.jeroen.plushie_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.exceptions.NotFoundException;
import dev.jeroen.plushie_backend.exceptions.NotUniqueException;
import dev.jeroen.plushie_backend.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
            throw new NotUniqueException("Username must be unique");
        }
        userRepository.save(user);
    }

    public CustomUser getByUsername(String username) {
        Optional<CustomUser> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new NotFoundException("User not found");
        }
        return user.get();
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
