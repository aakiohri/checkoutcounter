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
public class BillItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double quantity;
    private double purchaseCost;
    private double purchaseSalesTax;

    public BillItems(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
        this.purchaseCost = product.getCost() * quantity;
        this.purchaseSalesTax = product.getSalesTax() * quantity;
    }
}
