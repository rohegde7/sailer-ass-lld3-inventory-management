package com.example.ecomr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomPlaceOrder /*implements CommandLineRunner*/ {

//    @Autowired
//    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcomPlaceOrder.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Product product = new Product();
//        product.setName("Example Product");
//        product.setDescription("This is an example product.");
//        product.setPrice(19.99);
//
//        productRepository.save(product);
//
//        System.out.println("Product saved: " + product);
//    }

}
