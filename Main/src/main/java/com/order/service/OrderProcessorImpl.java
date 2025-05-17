package com.order.service;

import com.order.db.ProcessorRepository;
import com.order.model.Order;
import com.order.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OrderProcessorImpl implements OrderProcessor{

    Map<Long, Product> productDB = ProcessorRepository.getProductDB();
    Queue<Order> orderDB = ProcessorRepository.getOrderQueue();

    @Override
    public void processOrder() {

        for(Order order: orderDB){
            if(isValidOrder(order)){
                for(Product product: order.products()){
                    Product productInDB = productDB.get(product.productId());
                    long remainingStock =
                }

            }
        }

    }

    @Override
    public void placeOrder() {

        Product p1 = productDB.get(1L);
        Product p2 = productDB.get(2L);
        Product p3 = productDB.get(3L);

        List<Product> productList1 = List.of(p1,p2);
        List<Product> productList2 = List.of(p2,p3);

        Order order1 = new Order(1L,productList1);
        Order order2 = new Order(2L,productList2);

        orderDB.add(order1);
        orderDB.add(order2);
    }

    private boolean isValidOrder(Order order){
        List<Product> productList =  order.products();
        for(Product product: productList){
            if(!productDB.containsKey(product.productId())){
                System.out.println("Product out of stock: "+ product.productId());
                return false;
            }
            if(productDB.get(product.productId()).quantity() > product.quantity()){
                System.out.println("Not enough stock for Product "+ product.productId());
                return false;
            }
        }
        return true;
    }
}
