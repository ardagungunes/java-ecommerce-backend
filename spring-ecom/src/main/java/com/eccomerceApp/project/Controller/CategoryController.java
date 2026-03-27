package com.eccomerceApp.project.Controller;

import com.eccomerceApp.project.Model.Category;
import com.eccomerceApp.project.Service.CategoryService;
import com.eccomerceApp.project.Service.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/admin/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "A new category is added!";
    }

}
