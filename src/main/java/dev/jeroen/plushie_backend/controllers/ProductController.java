package dev.jeroen.plushie_backend.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository repository;
    public ProductController(ProductRepository rep){
        this.repository = rep;
    }

    @GetMapping("/first")
    public Product getFirst(){
        Optional<Product> product = repository.findById(1L);
        if (product.isPresent()){
            return product.get();
        }
        throw new Error("");
    }
}
