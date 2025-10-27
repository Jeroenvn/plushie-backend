package dev.jeroen.plushie_backend.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeroen.plushie_backend.dtos.ProductCreateDTO;
import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<String> postProduct(@RequestBody ProductCreateDTO product) {
        service.createProduct(product);
        return ResponseEntity.ok("Product succesfully created!");
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Product>> getAll() {
        ArrayList<Product> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable() Long id) {
        Product product = service.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable() Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Product succesfully deleted!");
    }

}
