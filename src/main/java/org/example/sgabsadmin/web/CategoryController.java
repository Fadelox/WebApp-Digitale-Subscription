package org.example.sgabsadmin.web;

import org.example.sgabsadmin.entites.Category;
import org.example.sgabsadmin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/addcategory")
    public Category ajouterrcategory(@RequestBody Category category){
        return categoryService.addrcategory(category);
    }
    @GetMapping("/categories")
    public List<Category> allrcategory(){
        return categoryService.getAllCategory();
    }
    @PostMapping("/upadtecategory/{id}")
    public Category editerrcategory(@PathVariable Long id,@RequestBody Category category){
        return categoryService.updatercategory(id,category);
    }
    @DeleteMapping("deletecategory/{id}")
    public void supprimercategory(@PathVariable Long id){
        categoryService.deletercategory(id);
    }
    @GetMapping("/searchcategory/{str}")
    public  List<Category> rechcategory(@PathVariable String str){  return categoryService.searchcategory(str);}
}
