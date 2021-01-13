package com.example.bss.product.management.service;

import com.example.bss.product.management.data.dto.CategoryDto;
import com.example.bss.product.management.data.dto.CategoryIncomingDto;
import com.example.bss.product.management.data.dto.CategoryPageDto;
import com.example.bss.product.management.data.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author John Mao
 * @created 1/7/21
 */
@Service
public class CategoryService {
    public CategoryDto createCategory(CategoryIncomingDto categoryIncomingDto) {
        Category category = new ModelMapper().map(categoryIncomingDto, Category.class);
        //TODO
        return null;
    }

    public Optional<CategoryDto> loadCategory(String id) {
        //TODO
        return null;
    }

    public Optional<CategoryDto> updateOrder(String id, CategoryIncomingDto categoryIncomingDto) {
        //TODO
        return null;
    }

    public CategoryPageDto getCategories(int page, int size, String sortField, String direction, List<String> status, String search) {
        //TODO
        return null;
    }
}
