package dev.jeroen.plushie_backend.dtos;

import java.util.List;

import dev.jeroen.plushie_backend.entities.OrderItem;

public class OrderDTO {

    private long id;
    private long userId;
    private List<OrderItem> orderItems;
    
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
}
