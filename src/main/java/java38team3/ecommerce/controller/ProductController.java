package java38team3.ecommerce.controller;

import java38team3.ecommerce.entities.Product;
import java38team3.ecommerce.entities.UserEntity;
import java38team3.ecommerce.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {

    private ProductRepository productRepository;

    @GetMapping
    public List<Product> addAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping ProductRepository addProduct(@PathVariable("productId") Long id){
        return (ProductRepository) productRepository.getById(id);
    }

    @PutMapping("/{userId}")
    public Product updateUser(@PathVariable("userId") Long id,@RequestBody Product request) {
        Product exists = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
        return productRepository.save(request);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable("productId") Long id){
        Product exists = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
        productRepository.deleteById(id);
    }
}
