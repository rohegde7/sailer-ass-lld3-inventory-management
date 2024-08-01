package com.example.ecomr.services;

import com.example.ecomr.exceptions.ProductNotFoundException;
import com.example.ecomr.exceptions.UnAuthorizedAccessException;
import com.example.ecomr.exceptions.UserNotFoundException;
import com.example.ecomr.models.Inventory;
import com.example.ecomr.models.Product;
import com.example.ecomr.models.User;
import com.example.ecomr.models.UserType;
import com.example.ecomr.repositories.InventoryRepository;
import com.example.ecomr.repositories.ProductRepository;
import com.example.ecomr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    ProductRepository productRepository;

    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (existingUser.getUserType() == UserType.CUSTOMER)
            throw new UnAuthorizedAccessException("User not authorized");

        Product product;
        List<Inventory> inventories = inventoryRepository.findAll();

        if (productRepository.findById(productId).isPresent()) {
            product = productRepository.findById(productId).get();
            for (Inventory inventory : inventories) {
                if (inventory.getProduct().getId() == product.getId()) {
                    inventory.setQuantity(inventory.getQuantity() + quantity);
                    return inventoryRepository.save(inventory);
                }
            }
        } else {
            product = new Product();
        }


        Inventory inventory = new Inventory();

        product.setId(productId);
        inventory.setQuantity(quantity);
        inventory.setProduct(product);
        productRepository.save(product);
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(int userId, int productId) throws UserNotFoundException, UnAuthorizedAccessException {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (existingUser.getUserType() == UserType.CUSTOMER)
            throw new UnAuthorizedAccessException("User not authorized");

        productRepository.deleteById(productId);
    }
}
