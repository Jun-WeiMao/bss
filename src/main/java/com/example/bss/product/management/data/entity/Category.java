package com.example.bss.product.management.data.entity;

import com.example.bss.common.data.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity {

    @Column(name = "category_name", length = 100, nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> categoryProducts = new HashSet<>();
}
