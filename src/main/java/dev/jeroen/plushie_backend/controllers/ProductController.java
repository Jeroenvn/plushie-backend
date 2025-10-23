package dev.jeroen.plushie_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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
    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping()
    public void postProduct(@RequestBody ProductCreateDTO product) {
        service.createProduct(product);
    }

    @GetMapping("/first")
    public Product getFirst(){
        return service.getFirst();
    }
}
