package dev.jeroen.plushie_backend.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.dtos.ProductCreateDTO;
import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.exceptions.NotFoundException;
import dev.jeroen.plushie_backend.exceptions.NotUniqueException;
import dev.jeroen.plushie_backend.repositories.ProductRepository;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(ProductCreateDTO productCreateDTO) {
        productCreateDTO.Validate();

        String productName = productCreateDTO.getName();
        if (repository.existsByName(productName)) {
            throw new NotUniqueException(String.format("Name '%s' is not unique", productName));
        }

        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setDescription(productCreateDTO.getDescription());

        repository.save(product);
    }

    public ArrayList<Product> getAll() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);

        if (!product.isPresent()) {
            throw new NotFoundException(String.format("Product with id %d not found", id));
        }

        return product.get();
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format("Product with id %d not found", id));
        }

        repository.deleteById(id);
    }
}
