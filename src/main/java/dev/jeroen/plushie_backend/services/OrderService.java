package dev.jeroen.plushie_backend.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.dtos.OrderItemDTO;
import dev.jeroen.plushie_backend.dtos.OrderCreateDTO;
import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.entities.Order;
import dev.jeroen.plushie_backend.entities.OrderItem;
import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.repositories.OrderItemRepository;
import dev.jeroen.plushie_backend.repositories.OrderRepository;

@Service
public class OrderService {

    private OrderRepository repository;
    private OrderItemRepository orderItemRepository;
    private UserService userService;
    private ProductService productService;

    public OrderService(OrderRepository repository, OrderItemRepository orderItemRepository, UserService userService,
            ProductService productService) {
        this.repository = repository;
        this.orderItemRepository = orderItemRepository;
        this.userService = userService;
        this.productService = productService;
    }

    public void createOrder(Long userId, OrderCreateDTO orderCreateDTO) {
        orderCreateDTO.validate();

        CustomUser user = userService.getById(userId);

        Order order = new Order();
        order.setUser(user);

        ArrayList<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemRequestDTO : orderCreateDTO.getOrderItems()) {
            Product product = productService.getProductById(orderItemRequestDTO.getProductId());
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setAmount(orderItemRequestDTO.getAmount());
        }

        Order savedOrder = repository.save(order);

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(savedOrder);
            orderItemRepository.save(orderItem);
        }
    }

    public ArrayList<Order> getOrders(Long userId) {
        CustomUser user = userService.getById(userId);
        return repository.findByUser(user);
    }

}
