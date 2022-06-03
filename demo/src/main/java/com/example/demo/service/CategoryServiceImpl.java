package com.example.demo.service;

import com.example.demo.model.CategoryModel;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> ListCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryModel> ListCategoriesById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel updateCategory(Integer id, CategoryModel categoryModel) {
        var categoryData = categoryRepository.findById(id).get();
        categoryData.setCategoryName(categoryModel.getCategoryName());
        return categoryRepository.save(categoryData);
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        try{
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
