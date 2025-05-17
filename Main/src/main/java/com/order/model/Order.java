package com.order.model;

import java.util.List;

public record Order(Long orderId, List<Product> products) {
}
