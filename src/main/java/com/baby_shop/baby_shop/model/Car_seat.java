package com.baby_shop.baby_shop.model;

import javax.persistence.*;

@Table(name = "car_seat")

@Entity
public class Car_seat extends Product {
    @Id
    @Column(name="prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prod_id;

    @Column(name = "kg_allowed")
    private int kg_allowed;

    @Column(name = "color")
    private String color;

    @Override
    public int getProd_id() {
        return prod_id;
    }

    @Override
    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getKg_allowed() {
        return kg_allowed;
    }

    public void setKg_allowed(int kg_allowed) {
        this.kg_allowed = kg_allowed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
