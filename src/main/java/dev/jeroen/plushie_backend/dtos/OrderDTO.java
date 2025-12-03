package dev.jeroen.plushie_backend.dtos;

import java.util.List;

public class OrderDTO {

    private long id;
    private long userId;
    private List<OrderItemDTO> orderItems;
    
    public OrderDTO() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
    
}
