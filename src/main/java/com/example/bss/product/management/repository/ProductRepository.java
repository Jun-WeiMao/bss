package com.example.bss.product.management.repository;

import com.example.bss.product.management.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
