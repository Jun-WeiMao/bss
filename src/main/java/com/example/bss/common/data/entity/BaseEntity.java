package com.example.bss.common.data.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

/**
 * <p>Root entity for object persistence via JPA.</p>
 *
 * @author John Mao
 * @created 1/7/21
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "custom-generator", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "custom-generator", strategy = "com.example.bss.common.data.entity.id.generator.BaseIdentifierGenerator")
    protected String id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;

    @Column
    @Version
    protected int version;

    /**
     * Indicates whether the object has already been persisted or not
     *
     * @return true if the object has not yet been persisted
     */
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public String toString() {
        return id;
    }
}
