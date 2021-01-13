package com.example.bss.product.management.repository;

import com.example.bss.product.management.data.entity.Customization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomizationRepository extends JpaRepository<Customization, Integer> {
}
