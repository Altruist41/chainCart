package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="order")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "OrderID")
    private int OrderID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name="Price")
    private int price;

    @Column(name="ProductTotalPrice")
    private float productTotalPrice;

    @Column(name = "Order_Date")
    private LocalDateTime Order_Date;

}

