package dev.jeroen.plushie_backend.repositories;

import dev.jeroen.plushie_backend.entities.CustomUser;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<CustomUser, Long> {

    CustomUser save(CustomUser user);

    Optional<CustomUser> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<CustomUser> findById(Long id);

    ArrayList<CustomUser> findAll();

}
