package com.hommies.inventoryservice.controller;

import com.hommies.inventoryservice.dto.InventoryResponse;
import com.hommies.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isAvailable(@RequestParam("skuCode") List<String> skuCode){
        return inventoryService.isAvailable(skuCode);
    }
}
