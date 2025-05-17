package com.order.db;

import com.order.model.Order;
import com.order.model.Product;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ProcessorRepository {
    private static volatile Queue<Order> orderQueue = null;
    private static volatile Map<Long, Product> productDB = null;

    private ProcessorRepository(){}

    //todo: Can use Holder Pattern
    public static Queue<Order> getOrderQueue(){
        if(orderQueue == null){
            synchronized (ProcessorRepository.class){
                if (orderQueue == null){
                    orderQueue = new LinkedList<>();
                }
            }
        }
        return orderQueue;
    }

    public static Map<Long, Product> getProductDB(){
        if(productDB == null){
            synchronized (ProcessorRepository.class){
                if(productDB == null){
                    productDB = new HashMap<>();
                }
            }
        }
        return productDB;
    }
}
