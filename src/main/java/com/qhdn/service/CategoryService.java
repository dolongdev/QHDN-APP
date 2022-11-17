package com.qhdn.service;

import com.qhdn.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();

    Category getCategory(Integer categoryId);
}
