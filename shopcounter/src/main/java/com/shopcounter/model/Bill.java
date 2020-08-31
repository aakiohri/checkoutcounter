package com.shopcounter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_purchase", joinColumns = @JoinColumn(name = "bill_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"))
    private Set<BillItems> billItems;

    private double totalCost;
    private double totalSaleTax;

    public Bill(Set<BillItems> billItems) {
        billItems.forEach(items -> {
            totalSaleTax += items.getPurchaseSalesTax();
            totalCost += items.getPurchaseCost();
        });
        this.billItems = billItems;
    }
}
