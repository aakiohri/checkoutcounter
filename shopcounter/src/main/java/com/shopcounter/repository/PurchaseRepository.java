package com.shopcounter.repository;

import com.shopcounter.model.BillItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<BillItems, Integer> {
}
