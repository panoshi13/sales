package com.example.demo.service;

import com.example.demo.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryModel> ListCategories();
    Optional<CategoryModel> ListCategoriesById(Integer id);
    CategoryModel createCategory(CategoryModel categoryModel);
    CategoryModel updateCategory(Integer id, CategoryModel categoryModel);
    Boolean deleteCategory(Integer id);
}
