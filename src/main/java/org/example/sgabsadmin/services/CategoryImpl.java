package org.example.sgabsadmin.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.sgabsadmin.entites.Category;
import org.example.sgabsadmin.entites.Produit;
import org.example.sgabsadmin.repositories.CategoryRepo;
import org.example.sgabsadmin.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService{
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProduitRepo produitRepo;
    @Override
    public Category addrcategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updatercategory(Long id, Category newCategory) {
        Optional<Category> categoryupadte = categoryRepo.findById(id);
        if (categoryupadte.isPresent()) {
            Category category = categoryupadte.get();
            category.setType(newCategory.getType());
            return categoryRepo.save(category);
        } else {
            throw new EntityNotFoundException("il n ya pas de Category de ID "+id);
        }
    }

    @Override
    public void deletercategory(Long id) {
        Optional<Category> optionalCategory=categoryRepo.findById(id);
        Optional<Category> optionalnewCategory= Optional.ofNullable(categoryRepo.findCategoryByType("undefined"));
        if (optionalnewCategory.isPresent()){

        if(optionalCategory.isPresent()){
            Category category=optionalCategory.get();
            List<Produit> produits=produitRepo.findProduitsByCategory(category);
            if (produits.size()>0){
                for (Produit produit:produits){
                    produit.setCategory(optionalnewCategory.get());
                    produitRepo.save(produit);
                }
            }



            categoryRepo.delete(category);
        }else {
            throw  new EntityNotFoundException("IL y a pas de category de ID "+id);

        }

    }else {
            throw  new EntityNotFoundException("IL y a pas de category type undifine");
        }
    }

    @Override
    public List<Category> searchcategory(String str) {
        return categoryRepo.findCategoriesByTypeContains(str);
    }


}
