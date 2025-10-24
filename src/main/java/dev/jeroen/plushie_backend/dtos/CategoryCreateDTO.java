package dev.jeroen.plushie_backend.dtos;

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
            throw new RuntimeException("Name is required");
        }
    }

    @Override
    public String toString() {
        return String.format("CategoryCreateDTO[name:'%s']", name);
    }
}
