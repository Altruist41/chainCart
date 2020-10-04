/*
package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.ShoppingCart;
import com.SandhyaJoshi.ShoppingSite.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShoppingCartImplementation implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart scart){
         return shoppingCartRepository.save(scart);
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart scart){
        return shoppingCartRepository.save(scart);
    }

    @Override
    public void deleteShoppingCart(int scartID){
        shoppingCartRepository.deleteById(scartID);
    }

}
*/
