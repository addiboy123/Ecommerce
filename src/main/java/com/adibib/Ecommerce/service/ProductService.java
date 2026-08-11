package com.adibib.Ecommerce.service;

import com.adibib.Ecommerce.entity.Product;
import com.adibib.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository repo;
    @Autowired
    ProductService(ProductRepository repo){this.repo=repo;}

    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    public Optional<Product> getProductById(int id){
        return repo.findById(id);
    }
    public void createProduct(Product prod){
        repo.save(prod);
    }
    public void updateProduct (Product prod){
        repo.save(prod);
    }
    public void deleteProductById(int id){
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
