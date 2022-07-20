package com.octa.gestorpedidos.controllers;

import com.octa.gestorpedidos.models.Item;
import com.octa.gestorpedidos.services.ItemService;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ApiResponse<List<Item>> findAll() {
        logger.info("GET /item");
        return itemService.findAll();
    }

    @GetMapping("{id}")
    public ApiResponse<Item> findById(@PathVariable Long id) {
        logger.info("GET /item/{id}");
        return itemService.findById(id);
    }

    @PostMapping
    public ApiResponse<Item> save(@RequestBody Item item) {
        logger.info("POST /item");
        return itemService.save(item);
    }

    @PutMapping
    public ApiResponse<Item> update(@RequestBody Item item) {
        logger.info("PUT /item");
        return itemService.update(item);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        logger.info("DELETE /item");
        itemService.delete(id);
    }
}
