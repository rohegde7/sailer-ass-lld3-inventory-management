package com.example.ecomr.controllers;

import com.example.ecomr.dtos.*;
import com.example.ecomr.models.Inventory;
import com.example.ecomr.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public CreateOrUpdateResponseDto createOrUpdateInventory(CreateOrUpdateRequestDto requestDto) {
        try {
            Inventory inventory = inventoryService.createOrUpdateInventory(
                    requestDto.getUserId(),
                    requestDto.getProductId(),
                    requestDto.getQuantity()
            );

            CreateOrUpdateResponseDto response = new CreateOrUpdateResponseDto();
            response.setInventory(inventory);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            return response;

        } catch (Exception e) {
            CreateOrUpdateResponseDto response = new CreateOrUpdateResponseDto();
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }

    public DeleteInventoryResponseDto deleteInventory(DeleteInventoryRequestDto requestDto) {
        DeleteInventoryResponseDto response = new DeleteInventoryResponseDto();

        try {
            inventoryService.deleteInventory(requestDto.getUserId(), requestDto.getProductId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }

}
