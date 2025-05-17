package com.order.db;

import com.order.model.Order;

import java.util.LinkedList;
import java.util.Queue;

public class ProcessorRepository {
    private static volatile Queue<Order> orderQueue = null;

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
}
