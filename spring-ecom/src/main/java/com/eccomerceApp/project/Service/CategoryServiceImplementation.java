package com.eccomerceApp.project.Service;

import com.eccomerceApp.project.Model.Category;
import com.eccomerceApp.project.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category not found with ID: " + id));

        categoryRepository.delete(category);

        return "Category with the ID: " + id + " is successfully removed.";
    }

    @Override
    public void updateCategory(Category updatedCategory, Long id) {

        Category currentCategory = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with categoryId: "+id + " is not found"));

        currentCategory.setCategoryName(updatedCategory.getCategoryName());

        categoryRepository.save(currentCategory);
    }
}
