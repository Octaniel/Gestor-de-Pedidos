package com.octa.gestorpedidos.controllers;

import com.octa.gestorpedidos.models.StockMovement;
import com.octa.gestorpedidos.services.StockMovementService;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stockMovement")
public class StockMovementController {

    Logger logger = LoggerFactory.getLogger(StockMovementController.class);
    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping
    public ApiResponse<List<StockMovement>> findAll() {
        logger.info("GET /stockMovement");
        return stockMovementService.findAll();
    }

    @GetMapping("{id}")
    public ApiResponse<StockMovement> findById(@PathVariable Long id) {
        logger.info("GET /stockMovement/{id}");
        return stockMovementService.findById(id);
    }

    @PostMapping
    public ApiResponse<StockMovement> save(@RequestBody StockMovement stockMovement) {
        logger.info("POST /stockMovement");
        return stockMovementService.save(stockMovement);
    }

    @PutMapping
    public ApiResponse<StockMovement> update(@RequestBody StockMovement stockMovement) {
        logger.info("PUT /stockMovement");
        return stockMovementService.update(stockMovement);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        logger.info("DELETE /stockMovement");
        stockMovementService.delete(id);
    }
}
