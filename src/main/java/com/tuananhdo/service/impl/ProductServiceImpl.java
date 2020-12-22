package com.tuananhdo.service.impl;

import com.tuananhdo.entity.Product;
import com.tuananhdo.repository.ProductRepository;
import com.tuananhdo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> finAll() {

        return productRepository.findAll();
    }


    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
