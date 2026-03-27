package com.eccomerceApp.project.Service;

import com.eccomerceApp.project.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private Long userId = 0L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        userId += 1;
        category.setCategoryId(userId);
        categories.add(category);
    }
}
