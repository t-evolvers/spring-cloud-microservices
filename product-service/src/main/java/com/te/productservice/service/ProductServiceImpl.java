package com.te.productservice.service;

import com.te.productservice.entity.Product;
import com.te.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    @Autowired
    private final ProductRepository productRepository;


    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = productRepository.getOne(product.getId());
        if ( null == productDB ) return null;
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        product.setCategorie(product.getCategorie());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB = getProduct(id);
        if ( null == productDB ) return null;
        productDB.setStatus("DELETED");
        return productRepository.save(productDB);
    }
}
