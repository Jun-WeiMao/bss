package com.example.bss.product.management.data.entity;

import com.example.bss.common.data.entity.BaseEntity;
import com.example.bss.order.management.data.entity.Discount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "specification")
    private String specification;

    @JsonIgnore
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Customization> productCustomizations = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "product")
    private Discount discount;
}
