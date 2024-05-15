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
public class ProduitImpl implements ProduitService{
    @Autowired
    ProduitRepo produitRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Produit addproduit(Produit produit) {
        return produitRepo.save(produit);
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepo.findAll();
    }

    @Override
    public Produit updateproduit(Long idP, Long idC, Produit produit) {
        Optional<Produit> optionalProduit=produitRepo.findById(idP);
        Optional<Category> optionalCategory=categoryRepo.findById(idC);
        if (optionalCategory.isPresent() && optionalProduit.isPresent()){
            Produit newproduit=optionalProduit.get();
            Category newcategory=optionalCategory.get();
            newproduit.setDuree(produit.getDuree());
            newproduit.setTitre(produit.getTitre());
            newproduit.setTarif(produit.getTarif());
            newproduit.setDescription(produit.getDescription());
            newproduit.setCategory(newcategory);
            return  produitRepo.save(newproduit);
        }else {
            throw new EntityNotFoundException("Il y a pas de produit ou category");
        }
    }

    @Override
    public void deleteproduit(Long id) {
        Optional<Produit> produitOptional=produitRepo.findById(id);
        if (produitOptional.isPresent()){
            Produit produit=produitOptional.get();
            produitRepo.delete(produit);
        }else {
            throw new EntityNotFoundException("il y  a le produit d Id "+id);
        }
    }

    @Override
    public List<Produit> searchproduitbytitre(String str) {
        return produitRepo.findProduitsByTitre(str);
    }

    @Override
    public List<Produit> searchproduitbydurre(int duree) {
        return produitRepo.findProduitsByDuree(duree);
    }

    @Override
    public List<Produit> searchproduitbytarif(int tarif) {
        return produitRepo.findProduitsByTarif(tarif);
    }

    @Override
    public List<Produit> searchproduitbycate(String category) {
        Optional<Category> optionalCategory= Optional.ofNullable(categoryRepo.findCategoryByType(category));
        if (optionalCategory.isPresent()){
            Category category1=optionalCategory.get();
            return produitRepo.findProduitsByCategory(category1);
        }
        return null;
    }



}
