package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    void save(List<Order> orders);

}
