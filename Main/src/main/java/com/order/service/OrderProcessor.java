package com.order.service;

import com.order.model.Order;

public interface OrderProcessor {
    Long processOrder(Order order);
}
