package dev.jeroen.plushie_backend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.repositories.ProductRepository;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public Product getProductById(Long id){
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()){
            return product.get();
        }
        throw new RuntimeException(String.format("Product with id %d not found", id));
    }

    public Product getFirst(){
        return getProductById(1L);
    }
}
