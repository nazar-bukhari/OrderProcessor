package com.order.service;

import com.order.model.Product;

public interface ProductProcessor {
    Long addProduct(Product product);
    Long updateProduct(Product product);
    void removeProduct(Long productId);
}
