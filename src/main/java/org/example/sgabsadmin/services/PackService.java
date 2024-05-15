package org.example.sgabsadmin.services;

import org.example.sgabsadmin.entites.Pack;
import org.example.sgabsadmin.entites.Produit;

import java.util.List;

public interface PackService {
    List<Pack> getAllPack();
    Pack addpack(Pack pack);
    List<Pack> searchpackbydure(int dure);
    List<Pack> searchpackbytitre(String str);
    List<Pack> searchpackbyproduit(String str);
    void deletepack(Long id);
    void deletepproduitfpack(Long packId, Long produitId);
    Pack updatepack(Long idp, Pack pack);
    Pack addprodtopack(Long idp, Long pack);


}
