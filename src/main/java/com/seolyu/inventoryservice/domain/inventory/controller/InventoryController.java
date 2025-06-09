package com.seolyu.inventoryservice.domain.inventory.controller;

import com.seolyu.inventoryservice.domain.inventory.controller.dto.DeductStockRequest;
import com.seolyu.inventoryservice.domain.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "inventory")
@RestController
@RequiredArgsConstructor
@RequestMapping("/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    @Operation(summary = "재고 여부 확인")
    @GetMapping("/{productId}/check")
    @ResponseStatus(HttpStatus.OK)
    public boolean isStockAvailable(@PathVariable Long productId) {
        return inventoryService.isStockAvailable(productId);
    }

    @Operation(summary = "재고 차감")
    @PatchMapping("/{productId}/deduct")
    @ResponseStatus(HttpStatus.OK)
    public void deductStock(@PathVariable Long productId, @RequestBody @Valid DeductStockRequest request) {
        inventoryService.deductStock(productId, request.getQuantity());
    }
}
