package dev.jeroen.plushie_backend.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import dev.jeroen.plushie_backend.entities.Product;

public interface ProductRepository extends Repository<Product, Long> {

    Product save(Product product);

    Optional<Product> findById(Long id);

    ArrayList<Product> findAll();

    void deleteById(Long id);

    boolean existsById(long id);

    boolean existsByName(String name);
}
