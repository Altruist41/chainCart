package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id  //ID will be a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increase generated value
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="billing_address")
    private String billingAddress;
    @Column(name="ether_address")
    private String etherAddress;

    //added 06-08
    @Column(name="allowed_companies")
    private String allowedCompanies;
    @Column(name="allowed_data")
    private String allowedData;
    @Column(name="allowed_purpose")
    private String allowedPurpose;
    @Column(name="allowed_reward")
    private String allowedReward;
    @Column(name="allowed_condition")
    private String allowedCondition;


    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;
    //transient because it won't be stored in database
    @Transient
    private String token;
}
