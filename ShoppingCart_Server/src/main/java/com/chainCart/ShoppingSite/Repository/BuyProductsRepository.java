package com.SandhyaJoshi.ShoppingSite.Repository;

import com.SandhyaJoshi.ShoppingSite.Model.BuyProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BuyProductsRepository extends JpaRepository<BuyProducts, Integer> {
    //List<BuyProducts> findByUserID(int user_id);

    @Query(value="SELECT * FROM buy_products as u, product as v where u.Product_ID=v.Product_ID and u.user_id= :user_id ",
            nativeQuery = true)
    //@Query("select user.transactionHash from BuyProducts as user where user.user_id = :user_id")
    List<BuyProducts> findByUserID(@Param("user_id")Integer user_id);
}
