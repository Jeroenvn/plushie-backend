package dev.jeroen.plushie_backend.controllers;

import java.util.ArrayList;

import dev.jeroen.plushie_backend.dtos.CategoryCreateDTO;
import dev.jeroen.plushie_backend.entities.Category;
import dev.jeroen.plushie_backend.services.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<String> postCategory(@RequestBody CategoryCreateDTO category) {
        service.createCategory(category);
        return ResponseEntity.ok("Category was succesfully created!");
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Category>> getAll() {
        ArrayList<Category> categories = service.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable() Long id) {
        Category category = service.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable() Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Category was succesfully deleted!");
    }

}
