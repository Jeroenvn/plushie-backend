package dev.jeroen.plushie_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/first")
    public Product getFirst(){
        return service.getFirst();
    }
}
