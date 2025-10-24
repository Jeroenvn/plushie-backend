package dev.jeroen.plushie_backend.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeroen.plushie_backend.dtos.ProductCreateDTO;
import dev.jeroen.plushie_backend.dtos.ProductDTO;
import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.mappers.ProductMapper;
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
    public void postProduct(@RequestBody ProductCreateDTO product) {
        service.createProduct(product);
    }

    @GetMapping("")
    public ArrayList<ProductDTO> getAll() {
        ArrayList<Product> products = service.getAll();
        ArrayList<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable("id") Long id) {
        Product product = service.getProductById(id);
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
