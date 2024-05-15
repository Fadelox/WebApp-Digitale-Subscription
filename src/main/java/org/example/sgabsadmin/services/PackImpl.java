package org.example.sgabsadmin.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.sgabsadmin.entites.Pack;
import org.example.sgabsadmin.entites.Produit;
import org.example.sgabsadmin.repositories.PackRepo;
import org.example.sgabsadmin.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackImpl implements PackService{
    @Autowired
    PackRepo packRepo;
    @Autowired
    ProduitRepo produitRepo;
    @Override
    public List<Pack> getAllPack() {
        return packRepo.findAll();
    }

    @Override
    public Pack addpack(Pack pack) {
        return packRepo.save(pack);
    }

    @Override
    public List<Pack> searchpackbydure(int dure) {

        return packRepo.findPacksByDuree(dure);
    }

    @Override
    public List<Pack> searchpackbytitre(String str) {
        return packRepo.findPacksByTitre(str);
    }

    @Override
    public List<Pack> searchpackbyproduit(String str) {
        Optional<Produit> optionalProduit=produitRepo.findProduitByTitre(str);
        if (optionalProduit.isPresent()){
            Produit produit=optionalProduit.get();
            return packRepo.findPacksByProduitsId(produit.getId());
        }else {
            throw new EntityNotFoundException("il y a pas de produits");
        }

    }



    @Override
    public void deletepack(Long id) {
        Optional<Pack> optionalPack=packRepo.findById(id);
        if (optionalPack.isPresent()){
            Pack pack=optionalPack.get();
            packRepo.delete(pack);
        }else {
            throw new EntityNotFoundException("Il y a pas de produit d ID "+id);
        }



    }

    @Override
    public void deletepproduitfpack(Long packId, Long produitId) {

                Optional<Pack> optionalPack = packRepo.findById(packId);
                if (optionalPack.isPresent()) {
                    Pack pack = optionalPack.get();

                    Optional<Produit> optionalProduit = pack.getProduits().stream().filter(produit -> produit.getId().equals(produitId)).findFirst();

                    if (optionalProduit.isPresent()) {
                        Produit produit = optionalProduit.get();
                        pack.getProduits().remove(produit);
                        packRepo.save(pack);
                    } else {
                        throw new EntityNotFoundException("Le produit avec l'ID " + produitId + " n'existe pas dans le pack avec l'ID " + packId);
                    }
                } else {
                    throw new EntityNotFoundException("Le pack avec l'ID " + packId + " n'existe pas");
                }





    }

    @Override
    public Pack updatepack(Long idp, Pack pack) {
        Optional<Pack> optionalPack=packRepo.findById(idp);
        if (optionalPack.isPresent()){
            Pack newpack=optionalPack.get();
            newpack.setDescription(pack.getDescription());
            newpack.setTitre(pack.getTitre());
            newpack.setDescription(pack.getDescription());
            newpack.setProduits(pack.getProduits());
            return  packRepo.save(newpack);

        }else {
            throw new EntityNotFoundException("Il y a pas de pack d ID"+idp);
        }



    }

    @Override
    public Pack addprodtopack(Long packId, Long produitId) {

        Optional<Pack> optionalPack = packRepo.findById(packId);
        if (optionalPack.isPresent()) {
            Pack pack = optionalPack.get();
            Optional<Produit> optionalProduit = produitRepo.findById(produitId);
            if (optionalProduit.isPresent()) {
                Produit produit = optionalProduit.get();
                if (!pack.getProduits().contains(produit)) {
                    pack.getProduits().add(produit);
                    packRepo.save(pack);
                } else {
                    throw new EntityNotFoundException("Le produit avec l'ID " + produitId + " est déjà dans le pack avec l'ID " + packId);
                }
            } else {
                throw new EntityNotFoundException("Le produit avec l'ID " + produitId + " n'existe pas");
            }
        } else {
            throw new EntityNotFoundException("Le pack avec l'ID " + packId + " n'existe pas");
        }
        return null;

    }
}
