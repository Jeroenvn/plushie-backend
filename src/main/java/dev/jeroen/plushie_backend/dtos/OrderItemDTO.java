package dev.jeroen.plushie_backend.dtos;

public class OrderItemDTO {
    
    private ProductDTO product;
    private int amount;

    public OrderItemDTO(ProductDTO product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
