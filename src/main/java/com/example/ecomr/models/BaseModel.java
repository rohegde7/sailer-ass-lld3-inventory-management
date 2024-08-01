package com.example.ecomr.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
}
