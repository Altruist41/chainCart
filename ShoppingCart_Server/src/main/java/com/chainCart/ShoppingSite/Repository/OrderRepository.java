package com.SandhyaJoshi.ShoppingSite.Repository;

import com.SandhyaJoshi.ShoppingSite.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
