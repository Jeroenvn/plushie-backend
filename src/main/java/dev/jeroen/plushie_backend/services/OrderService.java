package dev.jeroen.plushie_backend.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dev.jeroen.plushie_backend.dtos.OrderItemCreateDTO;
import dev.jeroen.plushie_backend.dtos.OrderItemDTO;
import dev.jeroen.plushie_backend.dtos.ProductDTO;
import dev.jeroen.plushie_backend.dtos.OrderCreateDTO;
import dev.jeroen.plushie_backend.dtos.OrderDTO;
import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.entities.Order;
import dev.jeroen.plushie_backend.entities.OrderItem;
import dev.jeroen.plushie_backend.entities.Product;
import dev.jeroen.plushie_backend.mappers.OrderMapper;
import dev.jeroen.plushie_backend.mappers.ProductMapper;
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

        for (OrderItemCreateDTO orderItemRequestDTO : orderCreateDTO.getOrderItems()) {
            Product product = productService.getProductById(orderItemRequestDTO.getProductId());
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setAmount(orderItemRequestDTO.getAmount());
            orderItems.add(orderItem);
        }

        Order savedOrder = repository.save(order);

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(savedOrder);
            orderItemRepository.save(orderItem);
        }

        System.out.println("\n\nCREATE\nuser id: " + user.getId() + "\nuser: " + user.toString() + "\nrawOrder: " + order.toString() + "\n1st orderitem: " + orderItems.getFirst().toString());

    }

    public ArrayList<OrderDTO> getOrders(Long userId) {
        CustomUser user = userService.getById(userId);
        ArrayList<Order> rawOrders = repository.findByUser(user);
        ArrayList<OrderDTO> orders = new ArrayList<>();
        for (Order rawOrder : rawOrders) {
            OrderDTO order = OrderMapper.INSTANCE.orderToOrderDTO(rawOrder);
            ArrayList<OrderItemDTO> orderItems = new ArrayList<>();
            for (OrderItem rawOrderItem : rawOrder.getOrderItems()) {
                Product product = productService.getProductById(rawOrderItem.getId());
                ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
                OrderItemDTO orderItem = new OrderItemDTO(productDTO, rawOrderItem.getAmount());
                orderItems.add(orderItem);
            }
            order.setOrderItems(orderItems);
            orders.add(order);
        }
        System.out.println("\n\nGET\nuser id: " + user.getId() + "\nuser: " + user.toString() + "\nrawOrders: " + rawOrders.toString() + "\norders: " + orders.toString());
        return orders;
    }

}
