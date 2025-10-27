package dev.jeroen.plushie_backend.dtos;

import org.springframework.http.HttpStatus;

import dev.jeroen.plushie_backend.exceptions.CustomRuntimeException;

public class ProductCreateDTO {

    private String name;
    private String description;
    private Long category_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public void Validate() {
        if (name.isEmpty()) {
            throw new CustomRuntimeException("Name is required", HttpStatus.BAD_REQUEST);
        }

        if (category_id == null) {
            throw new CustomRuntimeException("Category id is required", HttpStatus.BAD_REQUEST);
        }
    }

}
