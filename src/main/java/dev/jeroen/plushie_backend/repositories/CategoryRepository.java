package dev.jeroen.plushie_backend.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import dev.jeroen.plushie_backend.entities.Category;

public interface CategoryRepository extends Repository<Category, Long> {

    Category save(Category category);

    Optional<Category> findById(Long id);

    ArrayList<Category> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);

}
