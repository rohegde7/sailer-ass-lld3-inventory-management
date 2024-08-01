package com.example.ecomr.services;

import com.example.ecomr.exceptions.ProductNotFoundException;
import com.example.ecomr.exceptions.UnAuthorizedAccessException;
import com.example.ecomr.exceptions.UserNotFoundException;
import com.example.ecomr.models.Inventory;

//@Service
public interface InventoryService {
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException;
    public void deleteInventory(int userId, int productId) throws  UserNotFoundException, UnAuthorizedAccessException;
}
