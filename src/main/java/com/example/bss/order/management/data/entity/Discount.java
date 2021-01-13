package com.example.bss.order.management.data.entity;

import com.example.bss.common.data.entity.BaseEntity;
import com.example.bss.product.management.data.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Discount extends BaseEntity {

    @Column(name = "discount_rate", nullable = false)
    private BigDecimal discountRate;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
