package com.octa.gestorpedidos.controllers;

import com.octa.gestorpedidos.models.User;
import com.octa.gestorpedidos.services.UserService;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<User>> findAll() {
        logger.info("GET /user");
        return userService.findAll();
    }

    @GetMapping("{id}")
    public ApiResponse<User> findById(@PathVariable Long id) {
        logger.info("GET /user/{id}");
        return userService.findById(id);
    }

    @PostMapping
    public ApiResponse<User> save(@RequestBody User user) {
        logger.info("POST /user");
        return userService.save(user);
    }

    @PutMapping
    public ApiResponse<User> update(@RequestBody User user) {
        logger.info("PUT /user");
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        logger.info("DELETE /user");
        userService.delete(id);
    }
}
