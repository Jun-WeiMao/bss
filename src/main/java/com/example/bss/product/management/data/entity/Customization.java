package com.example.bss.product.management.data.entity;

import com.example.bss.common.data.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "customizations")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Customization extends BaseEntity {

    @Column(name = "customization_name", length = 100, nullable = false)
    private String customizationName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "default_stack", nullable = false)
    @NonNull
    private boolean defaultStack;

    @JsonIgnore
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
