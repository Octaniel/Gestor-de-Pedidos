package com.octa.gestorpedidos.services;

import com.octa.gestorpedidos.exceptions.RestException;
import com.octa.gestorpedidos.models.Item;
import com.octa.gestorpedidos.models.Order;
import com.octa.gestorpedidos.models.User;
import com.octa.gestorpedidos.repository.ItemRepository;
import com.octa.gestorpedidos.repository.OrderRepository;
import com.octa.gestorpedidos.repository.UserRepository;
import com.octa.gestorpedidos.wrappers.dto.OrderDto;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final SendEmail sendEmail;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, UserRepository userRepository,
                        SendEmail sendEmail) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.sendEmail = sendEmail;
    }

    public ApiResponse<List<Order>> findAll() {
        return new ApiResponse<>(orderRepository.findAll());
    }

    public ApiResponse<Order> findById(Long id) {
        return new ApiResponse<>(orderRepository.findById(id).orElse(null));
    }

    public ApiResponse<Order> save(OrderDto orderDto) {
        if (orderDto.getUserId() == null)
            throw new RestException("User not found");
        if (orderDto.getItemId() == null)
            throw new RestException("Item not found");
        User user = userRepository.findById(orderDto.getUserId()).orElse(null);
        if (user == null)
            throw new RestException("User not found");
        Item item = itemRepository.findById(orderDto.getItemId()).orElse(null);
        if (item == null)
            throw new RestException("Item not found");
        Order order = new Order();
        order.setCreationDate(LocalDateTime.now());
        order.setItem(item);
        order.setUser(user);
        sendEmail.sendEmail(user);
        return new ApiResponse<>(orderRepository.save(order));
    }

    public ApiResponse<Order> update(Order order) {
        if (order.getId() == null) {
            throw new RestException("Order id does not exist");
        }
        return new ApiResponse<>(orderRepository.save(order));
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
