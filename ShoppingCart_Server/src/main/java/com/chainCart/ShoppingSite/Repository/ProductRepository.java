package com.SandhyaJoshi.ShoppingSite.Repository;

import com.SandhyaJoshi.ShoppingSite.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
