package com.shopcounter;

import com.shopcounter.model.Category;
import com.shopcounter.model.Product;
import com.shopcounter.repository.CategoryRepository;
import com.shopcounter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShopcounterApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(ShopcounterApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) {

        Category categoryA = new Category("A", 10.00);
        Category categoryB = new Category("B", 20.00);
        Category categoryC = new Category("C", 0.00);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(categoryA);
        categoryList.add(categoryB);
        categoryList.add(categoryC);
        categoryRepository.saveAll(categoryList);

        Product productA = new Product("milk", 10.00, categoryA);
        Product productB = new Product("rasna", 20.00, categoryB);
        Product productC = new Product("bread", 30.00, categoryC);
        List<Product> productList = new ArrayList<>();
        productList.add(productA);
        productList.add(productB);
        productList.add(productC);
        productRepository.saveAll(productList);
    }
}
