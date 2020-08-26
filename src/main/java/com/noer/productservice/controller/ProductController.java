package com.noer.productservice.controller;

import com.noer.productservice.domain.Product;
import com.noer.productservice.exception.ProductException;
import com.noer.productservice.repository.ProductRepository;
import com.noer.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productservice")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/getproduct/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping(value = "/createProduct")
    public Product createNewProduct(@RequestBody Product product) {
        return productService.createNewProduct(product);
    }

    @DeleteMapping(value = "/product/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        Product product = productService.getProductById(id).orElseThrow(() -> new ProductException("Product Not Found"));
        productService.deleteProduct(product.getId());
        return "Product with id :"+ id +" is deleted";
    }
}
