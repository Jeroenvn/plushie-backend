package dev.jeroen.plushie_backend.dtos;

import java.util.ArrayList;

public class OrderRequestDTO {

    private ArrayList<OrderItemRequestDTO> orderItems;

    public ArrayList<OrderItemRequestDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItemRequestDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public void validate() {
        for (OrderItemRequestDTO orderItem : orderItems) {
            orderItem.validate();
        }
    }
}
