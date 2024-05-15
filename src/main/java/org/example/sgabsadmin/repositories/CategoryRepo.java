package org.example.sgabsadmin.repositories;

import org.example.sgabsadmin.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category findCategoryByType(String str);


    List<Category> findCategoriesByTypeContains(String str);

}
