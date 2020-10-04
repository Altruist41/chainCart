package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.Product;
import com.SandhyaJoshi.ShoppingSite.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productID) {
        productRepository.deleteById(productID);
    }

    @Override
    public Product findProductByID(int productID) {
        return productRepository.findById(productID).orElse(null);
    }

    @Override
    public List<Product> ListProduct() {
        return productRepository.findAll();
    }

    @Override
    public int numberOfProduct() {
        return (int) productRepository.count();
    }




}
