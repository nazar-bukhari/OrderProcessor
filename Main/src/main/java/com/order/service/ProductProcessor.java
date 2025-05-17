package com.order.service;

import com.order.model.Product;

public interface ProductProcessor {
    void createProductDB();
    Long addProduct(Product product) throws Exception;
    Long updateProduct(Product product) throws Exception;
    void removeProduct(Long productId);
}
