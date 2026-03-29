package com.eccomerceApp.project.Controller;

import com.eccomerceApp.project.Model.Category;
import com.eccomerceApp.project.Service.CategoryService;
import com.eccomerceApp.project.Service.CategoryServiceImplementation;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getAllCategories());
    }

    @PostMapping("/api/admin/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("A new category is added!");
    }

    @DeleteMapping("/api/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        try {
            String status = categoryService.deleteCategory(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(status);
        } catch (ResponseStatusException e){
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body(e.getReason());
        }
    }

}
