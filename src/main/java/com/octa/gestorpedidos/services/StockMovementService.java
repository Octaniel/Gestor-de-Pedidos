package com.octa.gestorpedidos.services;

import com.octa.gestorpedidos.exceptions.RestException;
import com.octa.gestorpedidos.models.StockMovement;
import com.octa.gestorpedidos.repository.StockMovementRepository;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockMovementService {
    private final StockMovementRepository stockMovementRepository;

    public StockMovementService(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    public ApiResponse<List<StockMovement>> findAll() {
        return new ApiResponse<>(stockMovementRepository.findAll());
    }

    public ApiResponse<StockMovement> findById(Long id) {
        return new ApiResponse<>(stockMovementRepository.findById(id).orElse(null));
    }

    public ApiResponse<StockMovement> save(StockMovement stockMovement) {
        stockMovement.setCreationDate(LocalDateTime.now());
        return new ApiResponse<>(stockMovementRepository.save(stockMovement));
    }

    public ApiResponse<StockMovement> update(StockMovement stockMovement) {
        if (stockMovement.getId() == null) {
            throw new RestException("StockMovement id does not exist");
        }
        return new ApiResponse<>(stockMovementRepository.save(stockMovement));
    }

    public void delete(Long id) {
        stockMovementRepository.deleteById(id);
    }
}
