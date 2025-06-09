package com.seolyu.inventoryservice.domain.inventory.entity;

import com.seolyu.inventoryservice.common.error.ErrorCode;
import com.seolyu.inventoryservice.common.error.exception.SeolyuException;
import com.seolyu.inventoryservice.common.model.BaseEntityDateAggregate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Inventory extends BaseEntityDateAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int stockQuantity = 0;

    public boolean isStockAvailable() {
        if (stockQuantity <= 0) {
            return false;
        }
        return true;
    }

    public void deduct(int quantity) {
        if (quantity <= 0) {
            throw new SeolyuException(ErrorCode.INVALID_DEDUCT_QUANTITY);
        }
        this.stockQuantity -= quantity;
    }
}
