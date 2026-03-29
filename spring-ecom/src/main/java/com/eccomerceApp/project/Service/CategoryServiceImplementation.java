package com.eccomerceApp.project.Service;

import com.eccomerceApp.project.Model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public String deleteCategory(Long id) {

        boolean removed = this.categories.removeIf(c -> c.getCategoryId().equals(id));

        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with ID: " + id);
        }

        return "Category with the ID: " + id + " is successfully removed.";
    }

    @Override
    public void updateCategory(Category updatedCategory, Long id) {
        Category currentCategory = categories
                .stream()
                .filter(c -> c.getCategoryId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with categoryId: "+id + " is not found"));

        currentCategory.setCategoryId(id);
        currentCategory.setCategoryName(updatedCategory.getCategoryName());
    }
}
