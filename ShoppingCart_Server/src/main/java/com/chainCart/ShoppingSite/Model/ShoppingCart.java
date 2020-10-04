/*
package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity  //if it is an entity, it must have an ID
@Data
@Table(name="ShoppingCart")
public class ShoppingCart {

    @Id
    @Column(name = "ShoppingCartID")
    private int ShoppingCartID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product.Product_ID", referencedColumnName = "Product_ID") //referencedColumnName where it originally belongs
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User.UserID", referencedColumnName = "user_id")
    private User user;

    @Column(name = "PurchaseDate")
    private LocalDateTime purchaseDate;

    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "OrderTotalPrice")
    private float OrderTotalPrice;

    ArrayList<ProductQuantityWrapper> productQ = new ArrayList<ProductQuantityWrapper>();

    //to add in cart, first check if the item is already in the cart. if yes increase qty else aadd product to the cart
    public void AddProductToCart(ProductQuantityWrapper productToCart){
        for(int i=0;i<productQ.size();i++){
            if(productQ.get(i).getProduct_ID().equals(productToCart.getProduct_ID())){
                productQ.get(i).setQuantity(productQ.get(i).getQuantity()+productToCart.getQuantity());
            }
            productQ.add(productToCart);
        }
    }

    public void DeleteFromCart(ProductQuantityWrapper productToDel){
        for(int i=0;i<productQ.size();i++){
            if(productQ.get(i).getProduct_ID().equals(productToDel.getProduct_ID())){
                productQ.remove(productToDel);
            }
        }
    }

    public void removeAllProduct(){
        productQ.clear();
    }


}
*/
