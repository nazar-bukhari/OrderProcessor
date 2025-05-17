package com.order.service;

import com.order.db.ProcessorRepository;
import com.order.model.Order;
import com.order.model.Product;

import java.util.List;

public class OrderProcessorImpl implements OrderProcessor{
    @Override
    public Long processOrder(Order order) {
        Long orderId = 0L;
        if(isValidOrder(order)){
            ProcessorRepository.getOrderQueue().add(order);
            orderId = order.orderId();
        }
        return orderId;
    }

    private boolean isValidOrder(Order order){
        List<Product> productList =  order.products();
        return true;
    }
}
