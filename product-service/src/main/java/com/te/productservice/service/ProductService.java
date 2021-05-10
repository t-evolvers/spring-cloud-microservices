package com.te.productservice.service;


import com.te.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProduct();

    Product getProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(Long id);


}
