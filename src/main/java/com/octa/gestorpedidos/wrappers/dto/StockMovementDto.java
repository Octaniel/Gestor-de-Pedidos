package com.octa.gestorpedidos.wrappers.dto;

import lombok.Data;

@Data
public class StockMovementDto {
    private Long itemId;
    private Double quantity;
}
