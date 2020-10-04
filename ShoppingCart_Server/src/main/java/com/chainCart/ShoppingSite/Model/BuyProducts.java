package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "buy_products")
public class BuyProducts  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trid")
    private int trid;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id",referencedColumnName = "user_id")  //you may not need referencedcolumnnane
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    private Product product;

    @Column(name = "Product_Quantity")
        private int proQuantity;

    @Column(name = "Total_Price_ETH")
    private double totalPrice;

    @Column(name = "transaction_hash")
    private String transactionHash;

    /*@Column(name = "Total_Price")
    private long totalPrice;

    //newly added
    @Column(name = "Order", columnDefinition ="JSON")
    private String order;

    @Column(name = "Billing_Address")
    private String billingAddress;

    @Column(name = "Ether_Address")
    private String etherAddress;*/

}
