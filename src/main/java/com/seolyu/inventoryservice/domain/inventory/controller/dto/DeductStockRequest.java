package com.seolyu.inventoryservice.domain.inventory.controller.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeductStockRequest {
    @Min(1)
    private int quantity;
}
