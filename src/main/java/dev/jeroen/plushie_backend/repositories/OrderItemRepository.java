package dev.jeroen.plushie_backend.repositories;

import org.springframework.data.repository.Repository;

import dev.jeroen.plushie_backend.entities.OrderItem;

public interface OrderItemRepository extends Repository<OrderItem, Long> {

    OrderItem save(OrderItem order);

}
