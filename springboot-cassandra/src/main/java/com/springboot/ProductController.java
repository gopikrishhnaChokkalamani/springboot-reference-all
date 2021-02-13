package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cassandra")
public class ProductController {
  
  @Autowired
  private ProductRepository productRepository;
  
  @GetMapping
  public List<Product> fetchProducts(){
    return productRepository.findAll();
  }
  
  @PostMapping
  public Product insertProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }
}
