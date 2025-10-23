package dev.jeroen.plushie_backend.dtos;

public class ProductCreateDTO {

    private String name;
    private String description;

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

    public void Validate() {
        if (name.isEmpty()) {
            throw new RuntimeException("Name is required");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "ProductCreateDTO[name:'%s', description:'%s']",
                name, description);
    }

}
