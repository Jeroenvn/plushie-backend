package dev.jeroen.plushie_backend.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.Repository;

import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.entities.Order;

public interface OrderRepository extends Repository<Order, Long> {

    Order save(Order order);

    ArrayList<Order> findByUser(CustomUser user);

}
