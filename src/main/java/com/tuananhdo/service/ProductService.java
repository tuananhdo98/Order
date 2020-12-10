package com.tuananhdo.service;

import com.tuananhdo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> finAll();

    void saveProduct(Product product);

    Product getProductById(long id);

    void deleteProduct(long id);

//    Iterator<Product> saveAllProduct(Product product);
}
