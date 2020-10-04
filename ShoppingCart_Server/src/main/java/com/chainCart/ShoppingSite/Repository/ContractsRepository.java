package com.SandhyaJoshi.ShoppingSite.Repository;

import com.SandhyaJoshi.ShoppingSite.Model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractsRepository extends JpaRepository<Contracts, Integer> {
    @Query(value="SELECT * FROM contracts as u where u.user_id= :user_id", nativeQuery = true)
    List<Contracts> findByUserID(@Param("user_id")Integer user_id);
}
