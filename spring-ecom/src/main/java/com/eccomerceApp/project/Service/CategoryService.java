package com.eccomerceApp.project.Service;

import com.eccomerceApp.project.Model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long id);

}
