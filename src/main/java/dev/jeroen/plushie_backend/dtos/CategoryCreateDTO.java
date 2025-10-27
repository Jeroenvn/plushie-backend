package dev.jeroen.plushie_backend.dtos;

import org.springframework.http.HttpStatus;

import dev.jeroen.plushie_backend.exceptions.CustomRuntimeException;

public class CategoryCreateDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Validate() {
        if (name.isEmpty()) {
            throw new CustomRuntimeException("Name is required", HttpStatus.BAD_REQUEST);
        }
    }

}
