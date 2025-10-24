package dev.jeroen.plushie_backend.dtos;

import dev.jeroen.plushie_backend.exceptions.MissingRequiredVariableException;

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
            throw new MissingRequiredVariableException("Name is required");
        }

        if (category_id == null) {
            throw new MissingRequiredVariableException("Category id is required");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "ProductCreateDTO[name:'%s', description:'%s']",
                name, description);
    }

}
