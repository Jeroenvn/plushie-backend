package dev.jeroen.plushie_backend.dtos;

import java.util.ArrayList;

public class OrderCreateDTO {

    private ArrayList<OrderItemCreateDTO> orderItems;

    public ArrayList<OrderItemCreateDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItemCreateDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public void validate() {
        for (OrderItemCreateDTO orderItem : orderItems) {
            orderItem.validate();
        }
    }
}
