package com.example.bss.product.management.controller;

import com.example.bss.product.management.data.dto.CategoryDto;
import com.example.bss.product.management.data.dto.CategoryIncomingDto;
import com.example.bss.product.management.data.dto.CategoryPageDto;
import com.example.bss.product.management.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author John Mao
 * @created 1/7/21
 */
@RestController
@RequestMapping(path = {"/api/v1/categories"}, produces = APPLICATION_JSON_VALUE)
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private static final String ID = "categoryId";
    private static final String NEW_CATEGORY_LOG = "New category was created id:{}";
    private static final String CATEGORY_UPDATED_LOG = "Category:{} was updated";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create a new category")
    @ApiResponse(responseCode = "201", description = "Category is created", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = CategoryDto.class))})
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryIncomingDto categoryIncomingDto) {
        final CategoryDto createdCategory = categoryService.createCategory(categoryIncomingDto);
        logger.info(NEW_CATEGORY_LOG, createdCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @Operation(summary = "Get a category by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the category", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)})
    @GetMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDto> loadCategory(@PathVariable(value = ID) String id) {
        final Optional<CategoryDto> category = categoryService.loadCategory(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an category by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Category was updated", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)})
    @PutMapping(path = "/{categoryId}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> updateCustomQuoteRequest(@PathVariable(value = ID) String id, @Valid @RequestBody CategoryIncomingDto categoryIncomingDto) {
        final Optional<CategoryDto> updatedCategory = categoryService.updateOrder(id, categoryIncomingDto);
        if (updatedCategory.isPresent()) {
            logger.info(CATEGORY_UPDATED_LOG, updatedCategory);
            return ResponseEntity.ok(updatedCategory.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Returns a list of category and sorted/filtered based on the query parameters")
    @ApiResponse(responseCode = "200", description = "Order was updated", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = CategoryPageDto.class))})
    @GetMapping
    public ResponseEntity<CategoryPageDto> getCategories(
            @RequestParam(required = false, name = "page", defaultValue = "0") int page,
            @RequestParam(required = false, name = "size", defaultValue = "20") int size,
            @RequestParam(required = false, name = "sortField", defaultValue = "createdAt") String sortField,
            @RequestParam(required = false, name = "direction", defaultValue = "DESC") String direction,
            @RequestParam(required = false, name = "status") List<String> status,
            @RequestParam(required = false, name = "search") String search
    ) {
        final CategoryPageDto ordersPage = categoryService.getCategories(page, size, sortField, direction, status, search);
        return ResponseEntity.ok(ordersPage);
    }
}
