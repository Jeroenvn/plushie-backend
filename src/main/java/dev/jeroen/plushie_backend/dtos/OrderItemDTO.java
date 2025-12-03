package dev.jeroen.plushie_backend.dtos;

import org.springframework.http.HttpStatus;

import dev.jeroen.plushie_backend.exceptions.CustomRuntimeException;

public class OrderItemDTO {

    private Long productId;
    private int amount;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void validate() {
        if (productId == null) {
            throw new CustomRuntimeException("Product id is required", HttpStatus.BAD_REQUEST);
        }
        if (amount <= 0) {
            throw new CustomRuntimeException("Amount must positive", HttpStatus.BAD_REQUEST);
        }
    }

}
