package com.qhdn.service.impl;

import com.qhdn.entity.Category;
import com.qhdn.exceptions.ResourceNotFoundException;
import com.qhdn.repository.CategoryRepo;
import com.qhdn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = this.categoryRepo.findAll();
        return list;
    }

    @Override
    public Category getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category", categoryId));
        return category;
    }
}
