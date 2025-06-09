package com.seolyu.inventoryservice.domain.inventory.service;

import com.seolyu.inventoryservice.common.error.ErrorCode;
import com.seolyu.inventoryservice.common.error.exception.SeolyuException;
import com.seolyu.inventoryservice.domain.inventory.entity.Inventory;
import com.seolyu.inventoryservice.domain.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isStockAvailable(Long productId) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(productId);
        if (optionalInventory.isPresent()) {
            Inventory inventory = optionalInventory.get();
            return inventory.isStockAvailable();
        }
        return false;
    }

    @Transactional
    public void deductStock(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new SeolyuException(ErrorCode.INVENTORY_NOT_FOUND));

        if (inventory.getStockQuantity() < quantity) {
            throw new SeolyuException(ErrorCode.INSUFFICIENT_STOCK);
        }

        inventory.deduct(quantity);
    }
}
