package org.example.sgabsadmin.services;

import org.example.sgabsadmin.entites.Category;

import java.util.List;

public interface CategoryService {
    Category addrcategory(Category category);
    List<Category> getAllCategory();
    Category updatercategory(Long id,Category category);
    void deletercategory(Long id);
    List<Category> searchcategory(String str);
}
