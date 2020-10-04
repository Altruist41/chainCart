package com.SandhyaJoshi.ShoppingSite.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="contracts")
public class Contracts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int contract_id;

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
    @Column(name="contract_hash")
    private String contractHash;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id",referencedColumnName = "user_id")  //you may not need referencedcolumnnane
    private User user;
}
