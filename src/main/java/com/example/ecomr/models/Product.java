package com.example.ecomr.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product extends BaseModel {
    private String name;
    private String description;
    private double price;
    // M : 1
//    @ManyToOne
//    private User user;
}
