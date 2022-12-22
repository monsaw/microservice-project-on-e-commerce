package com.hommies.inventoryservice.service;

import com.hommies.inventoryservice.dto.InventoryResponse;
import com.hommies.inventoryservice.model.Inventory;
import com.hommies.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isAvailable(List<String> skuCodes){
        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCodes);
        return inventories.stream().map(inventory -> InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isPresent(inventory.getQuantity() > 0)
                .build()).toList();
    }
}
