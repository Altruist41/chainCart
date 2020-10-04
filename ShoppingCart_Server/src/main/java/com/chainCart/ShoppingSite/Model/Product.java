package com.SandhyaJoshi.ShoppingSite.Model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Product_ID;
    @Column(name="Product_Category")
    private String proCategory;
    @Column(name="Product_Brand")
    private String proBrand;
    @Column(name="product_model_no")
    private String product_model_no;
    @Column(name="Product_Name")
    private String proName;
    @Column(name="Product_Price")
    private double proPrice;
    @Column(name="Product_Stock")
    private int proStock;
    @Column(name="Product_Description")
    private String proDesc;
    @Column(name = "Product_ImageURL")
    private String proImageURL;
}
