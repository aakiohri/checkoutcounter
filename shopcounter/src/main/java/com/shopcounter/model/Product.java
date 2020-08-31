package com.shopcounter.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private double salesTax;

    public Product(String name, double cost, Category category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.salesTax = ((cost * category.getSalestax()) / 100);
    }
}
