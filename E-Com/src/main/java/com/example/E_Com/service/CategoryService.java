package com.example.E_Com.service;

import java.util.List;
import com.example.E_Com.model.Category;

public interface CategoryService {

    Category saveCategory(Category category);

    Boolean existCategory(String name);

    List<Category> getAllCategory();

    Boolean deleteCategory(int id);

    Category getCategoryById(long id);
}