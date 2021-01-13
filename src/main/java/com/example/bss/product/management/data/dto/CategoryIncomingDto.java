package com.example.bss.product.management.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.Instant;

/**
 * Incoming DTO to create a new record of {@link com.example.bss.product.management.data.entity.Category}
 *
 * @author John Mao
 * @created 1/7/21
 */
@Getter
@Setter
public class CategoryIncomingDto {

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    @Max(100)
    private String categoryName;

    @JsonProperty(required = true)
    @NotNull
    @PastOrPresent
    private Instant modifiedAt;
}
