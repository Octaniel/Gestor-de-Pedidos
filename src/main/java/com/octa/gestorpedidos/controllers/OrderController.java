package com.octa.gestorpedidos.controllers;

import com.octa.gestorpedidos.models.Order;
import com.octa.gestorpedidos.services.OrderService;
import com.octa.gestorpedidos.wrappers.dto.OrderDto;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ApiResponse<List<Order>> findAll() {
        logger.info("GET /order");
        return orderService.findAll();
    }

    @GetMapping("{id}")
    public ApiResponse<Order> findById(@PathVariable Long id) {
        logger.info("GET /order/{id}");
        return orderService.findById(id);
    }

    @PostMapping
    public ApiResponse<Order> save(@RequestBody OrderDto order) {
        logger.info("POST /order");
        return orderService.save(order);
    }

    @PutMapping
    public ApiResponse<Order> update(@RequestBody Order order) {
        logger.info("PUT /order");
        return orderService.update(order);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        logger.info("DELETE /order");
        orderService.delete(id);
    }
}
