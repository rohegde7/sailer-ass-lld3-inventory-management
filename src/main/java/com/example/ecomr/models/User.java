package com.example.ecomr.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "users")
public class User extends BaseModel{
    private String name;
    private String email;

    @Enumerated(value = EnumType.ORDINAL)
    private UserType userType;

//    @OneToOne
//    private Inventory inventory;
}
