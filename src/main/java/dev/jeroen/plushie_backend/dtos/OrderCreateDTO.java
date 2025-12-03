package dev.jeroen.plushie_backend.dtos;

import java.util.ArrayList;

public class OrderCreateDTO {

    private ArrayList<OrderItemDTO> orderItems;

    public ArrayList<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public void validate() {
        for (OrderItemDTO orderItem : orderItems) {
            orderItem.validate();
        }
    }
}
