package dev.jeroen.plushie_backend.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.dtos.CategoryCreateDTO;
import dev.jeroen.plushie_backend.entities.Category;
import dev.jeroen.plushie_backend.exceptions.NotFoundException;
import dev.jeroen.plushie_backend.exceptions.NotUniqueException;
import dev.jeroen.plushie_backend.exceptions.ViolatingContstrainsException;
import dev.jeroen.plushie_backend.repositories.CategoryRepository;

@Service
public class CategoryService {

    CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public void createCategory(CategoryCreateDTO categoryCreateDTO) {
        categoryCreateDTO.Validate();

        String categoryName = categoryCreateDTO.getName();
        if (repository.existsByName(categoryName)) {
            throw new NotUniqueException(String.format("Name '%s' is not unique", categoryName));
        }

        Category category = new Category();
        category.setName(categoryName);

        repository.save(category);
    }

    public ArrayList<Category> getAll() {
        return repository.findAll();
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);

        if (!category.isPresent()) {
            throw new NotFoundException(String.format("Category with id %d not found", id));
        }

        return category.get();
    }

    public void deleteById(Long id) {
        Category category = getCategoryById(id);

        if (!category.getProducts().isEmpty()) {
            throw new ViolatingContstrainsException(String.format(
                    "Category cannot be deleted while there are products connected to it. %d products connected",
                    category.getProducts().size()));
        }

        repository.deleteById(id);
    }

}
