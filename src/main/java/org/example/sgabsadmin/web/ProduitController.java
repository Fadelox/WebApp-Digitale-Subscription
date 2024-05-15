package org.example.sgabsadmin.web;


import org.example.sgabsadmin.entites.Category;
import org.example.sgabsadmin.entites.Produit;
import org.example.sgabsadmin.services.CategoryService;
import org.example.sgabsadmin.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/produit")
public class ProduitController {
    @Autowired
    ProduitService produitService;
    @Autowired
    CategoryService categoryService;
    @PostMapping("/addproduit")
    public Produit ajouterproduit(@RequestBody Produit produit){
        return produitService.addproduit(produit);

    }
    @GetMapping("/produits")
    public List<Produit> allproduit(){
        return produitService.getAllProduit();
    }
    @PostMapping("/updateproduit/{idP}/{idC}")
    public Produit editeproduit(@PathVariable Long idP,@PathVariable Long idC,@RequestBody Produit produit){
        return produitService.updateproduit(idP,idC,produit);
    }

    @DeleteMapping("/deleteproduit/{id}")
    public  void supprimproduit(@PathVariable Long id){
        produitService.deleteproduit(id);
    }
    @GetMapping("/getprobytitle/{str}")
    public List<Produit> rechprobytitre(@PathVariable String str){
        return produitService.searchproduitbytitre(str);
    }
    @GetMapping("/getprobyduree/{duree}")
    public List<Produit> rechprobydure(@PathVariable int duree){
        return produitService.searchproduitbydurre(duree);
    }
    @GetMapping("/getprobytarif/{tarif}")
    public List<Produit> rechprobytarif(@PathVariable int tarif){
        return produitService.searchproduitbytarif(tarif);
    }
    @GetMapping("/getprobycate/{str}")
    public  List<Produit> rechprobycate(@PathVariable String str){
        return produitService.searchproduitbycate(str);
    }









}
