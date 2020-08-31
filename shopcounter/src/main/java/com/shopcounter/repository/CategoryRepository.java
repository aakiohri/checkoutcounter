package com.shopcounter.repository;


import com.shopcounter.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT t FROM Category t WHERE t.name = ?1")
    Category findCategoryByName(String categoryName);
}
