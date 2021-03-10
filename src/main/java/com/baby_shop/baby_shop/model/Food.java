package com.baby_shop.baby_shop.model;

import javax.persistence.*;

@Table(name = "food")

@Entity
public class Food extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "nutrition")
    private String nutrition;

    @Override
    public int getProd_id() {
        return prod_id;
    }

    @Override
    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }
}
