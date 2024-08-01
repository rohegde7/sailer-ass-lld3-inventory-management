package com.example.ecomr;

import lombok.Data;

@Data
public class TestAnnotations {

    private final String name;
    private final int age;
}

class Mai {
    public static void main(String[] args) {
        TestAnnotations t = new TestAnnotations("Rohit", 10);
    }
}
