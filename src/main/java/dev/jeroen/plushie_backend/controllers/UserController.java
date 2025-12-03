package dev.jeroen.plushie_backend.controllers;

import dev.jeroen.plushie_backend.dtos.OrderCreateDTO;
import dev.jeroen.plushie_backend.entities.CustomUser;
import dev.jeroen.plushie_backend.entities.Order;
import dev.jeroen.plushie_backend.services.OrderService;
import dev.jeroen.plushie_backend.services.UserService;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private OrderService orderService;

    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<CustomUser>> getAll() {
        ArrayList<CustomUser> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{id}/orders")
    public ResponseEntity<String> postOrder(@PathVariable() Long id, @RequestBody OrderCreateDTO orderCreateDTO) {
        orderService.createOrder(id, orderCreateDTO);
        return ResponseEntity.ok("Order was succesfully created!");
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<ArrayList<Order>> getOrders(@PathVariable() Long id) {
        ArrayList<Order> orders = orderService.getOrders(id);
        return ResponseEntity.ok(orders);
    }

}
