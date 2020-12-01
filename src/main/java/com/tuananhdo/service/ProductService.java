package com.tuananhdo.service;

import com.tuananhdo.entity.Product;
import com.tuananhdo.entity.SpecialMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> finAll();

    void saveProduct(Product product);

    Product getProductById(int id);

    void deleteProduct(int id);
}
