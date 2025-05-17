package com.order.service;

import com.order.db.ProcessorRepository;
import com.order.model.Product;

import java.util.Map;

public class ProductProcessorImpl implements ProductProcessor{
    @Override
    public void createProductDB() {
        Map<Long, Product> productDB = ProcessorRepository.getProductDB();
        Product p1 = new Product(1L, 100, 5L);
        Product p2 = new Product(2L, 200, 10L);
        Product p3 = new Product(3L, 300, 15L);
        productDB.put(p1.productId(),p1);
        productDB.put(p2.productId(),p2);
        productDB.put(p3.productId(),p3);
    }

    @Override
    public Long addProduct(Product product) throws Exception {
        Map<Long, Product> productDB = ProcessorRepository.getProductDB();
        if(productDB.containsKey(product.productId())){
            throw new Exception("Adding Duplicate Product is Prohibited: "+ product.productId());
        }
        productDB.put(product.productId(), product);
        return product.productId();
    }

    @Override
    public Long updateProduct(Product product) throws Exception {
        Map<Long, Product> productDB = ProcessorRepository.getProductDB();
        if(!productDB.containsKey(product.productId())){
            throw new Exception("Product Does not exist: "+ product.productId());
        }
        productDB.put(product.productId(), product);
        return product.productId();
    }

    @Override
    public void removeProduct(Long productId) {

    }
}
