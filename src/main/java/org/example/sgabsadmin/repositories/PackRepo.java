package org.example.sgabsadmin.repositories;

import org.example.sgabsadmin.entites.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackRepo extends JpaRepository<Pack,Long> {

    List<Pack> findPacksByDuree(int duree);
    List<Pack> findPacksByTitre(String str);
    List<Pack> findPacksByProduitsId(Long produitId);



}
