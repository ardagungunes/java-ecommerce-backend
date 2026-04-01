package com.eccomerceApp.project.Repository;

import com.eccomerceApp.project.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
