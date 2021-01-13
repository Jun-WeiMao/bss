package com.example.bss.product.management.repository;

import com.example.bss.product.management.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
