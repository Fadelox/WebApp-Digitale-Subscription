package org.example.sgabsadmin.services;

import org.example.sgabsadmin.entites.Category;
import org.example.sgabsadmin.entites.Produit;

import java.util.List;

public interface ProduitService {
    Produit addproduit(Produit produit);
    List<Produit> getAllProduit();
    Produit updateproduit(Long idP,Long idC,Produit produit);
    void deleteproduit(Long id);
    List<Produit> searchproduitbytitre(String str);

    List<Produit> searchproduitbydurre(int duree);
    List<Produit> searchproduitbytarif(int tarif);

    List<Produit> searchproduitbycate(String category);


}
