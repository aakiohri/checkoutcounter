package com.shopcounter.service;


import com.shopcounter.controller.dto.BillingDto;
import com.shopcounter.exceptions.ResourceNotFoundException;
import com.shopcounter.model.Bill;
import com.shopcounter.model.BillItems;
import com.shopcounter.model.Product;
import com.shopcounter.repository.BillRepository;
import com.shopcounter.repository.ProductRepository;
import com.shopcounter.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class StoreServiceImpl implements StoreService<Bill, BillingDto> {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Transactional
    public Bill create(BillingDto input) {

        Set<BillItems> billItems = new HashSet<>();

        input.getPurchase().forEach(purchase -> {
            Product productByName = productRepository.findProductByName(purchase.getProductName().toLowerCase());
            if (productByName != null) {
                BillItems temp = new BillItems(productByName, Integer.valueOf(purchase.getQuantity()));
                purchaseRepository.save(temp);
                billItems.add(temp);
            } else {
                throw new ResourceNotFoundException(purchase.getProductName() + " is not present in the inventory");
            }
        });

        Bill bill = new Bill(billItems);
        return billRepository.save(bill);
    }

    public Bill find(int input) {

        Optional<Bill> one = billRepository.findById(input);
        if (one.isPresent()) {
            return one.get();
        } else {
            throw new ResourceNotFoundException("Bill not found with Id " + input);
        }
    }

    @Override
    public List<Bill> find() {
        return billRepository.findAll();
    }
}
