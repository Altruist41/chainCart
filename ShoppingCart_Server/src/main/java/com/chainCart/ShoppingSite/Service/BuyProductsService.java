package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.BuyProducts;

import java.util.List;

public interface BuyProductsService {

    BuyProducts saveTransaction(BuyProducts buyProducts);
    List<BuyProducts> findByUserID(int user_id);

}
