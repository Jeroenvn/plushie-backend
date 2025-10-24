package dev.jeroen.plushie_backend.controllers;

import java.util.ArrayList;

import dev.jeroen.plushie_backend.dtos.CategoryCreateDTO;
import dev.jeroen.plushie_backend.dtos.CategoryDTO;
import dev.jeroen.plushie_backend.entities.Category;
import dev.jeroen.plushie_backend.mappers.CategoryMapper;
import dev.jeroen.plushie_backend.services.CategoryService;

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
    public void postCategory(@RequestBody CategoryCreateDTO category) {
        service.createCategory(category);
    }

    @GetMapping("")
    public ArrayList<CategoryDTO> getAll() {
        ArrayList<Category> categories = service.getAll();

        ArrayList<CategoryDTO> categoryDTOs = new ArrayList<>();

        for (Category category : categories) {
            CategoryDTO categoryGetDTO = CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
            categoryDTOs.add(categoryGetDTO);
        }

        return categoryDTOs;
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable() Long id) {
        Category category = service.getCategoryById(id);
        return CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable() Long id) {
        service.deleteById(id);
    }

}
