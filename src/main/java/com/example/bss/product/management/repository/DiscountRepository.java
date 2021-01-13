package com.example.bss.product.management.repository;

import com.example.bss.order.management.data.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
