package dev.jeroen.plushie_backend.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.dtos.ProductCreateDTO;
import dev.jeroen.plushie_backend.entities.Category;
import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.exceptions.CustomRuntimeException;
import dev.jeroen.plushie_backend.repositories.ProductRepository;

@Service
public class ProductService {

    ProductRepository repository;
    CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public void createProduct(ProductCreateDTO productCreateDTO) {
        productCreateDTO.Validate();

        String productName = productCreateDTO.getName();
        if (repository.existsByName(productName)) {
            throw new CustomRuntimeException("Name must be unique", HttpStatus.BAD_REQUEST);
        }

        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setDescription(productCreateDTO.getDescription());

        Category category = categoryService.getCategoryById(productCreateDTO.getCategory_id());
        product.setCategory(category);

        repository.save(product);
    }

    public ArrayList<Product> getAll() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);

        if (!product.isPresent()) {
            throw new CustomRuntimeException("Product not found", HttpStatus.NOT_FOUND);
        }

        return product.get();
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new CustomRuntimeException("Product not found", HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);
    }

}
