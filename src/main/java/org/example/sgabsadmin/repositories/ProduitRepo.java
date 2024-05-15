package org.example.sgabsadmin.repositories;

import org.example.sgabsadmin.entites.Category;
import org.example.sgabsadmin.entites.Pack;
import org.example.sgabsadmin.entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
    List<Produit> findProduitsByCategory(Category category);
    List<Produit> findProduitsByDuree(int duree);
    List<Produit> findProduitsByTarif(int tarif);

    List<Produit> findProduitsByTitre(String titre);
    Optional<Produit> findProduitByTitre(String titre);



}
