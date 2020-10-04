package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(int productID);

    Product findProductByID(int productID);

    List<Product> ListProduct();

    int numberOfProduct();
}
