package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ehcache")
public class ProductController {
  
  @Autowired
  private ProductRepository productRepository;
  
  @GetMapping
  @Cacheable(value = AppCache.TWENTY_SECOND_CACHE, unless = "#result == null")
  //key = "'ProductController/' + #p0.id"
  //condition = "#p0.name.equals("john")"
  //in conditon you can also use logical operations to combine scenarios
  public List<Product> fetchProducts(){
    return productRepository.findAll();
  }

  //@CachePut - everytime the method will be called and updated the cache
  //scenario, you update cache here and use it somewhere else

  @PostMapping
  @CacheEvict(value = AppCache.TWENTY_SECOND_CACHE, beforeInvocation = true)
  public Product insertProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }
}
