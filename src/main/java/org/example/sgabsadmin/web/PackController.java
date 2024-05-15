package org.example.sgabsadmin.web;

import org.example.sgabsadmin.entites.Pack;
import org.example.sgabsadmin.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/packs")
public class PackController {
    @Autowired
    PackService packService;
    @PostMapping("/addpack")
    public Pack ajoutpack(@RequestBody Pack pack){
        return packService.addpack(pack);
    }
    @PostMapping("/packs")
    public List<Pack> Allpack(){
        return packService.getAllPack();
    }
    @GetMapping("/getpackbydure/{dure}")
    public List<Pack> recherchpackbydure(@PathVariable int dure){
        return packService.searchpackbydure(dure);
    }

    @GetMapping("/getpackbytitre/{str}")
    public List<Pack> recherchpakbytitre(@PathVariable String str){
        return packService.searchpackbytitre(str);
    }
    @GetMapping("/getpackbyprod/{str}")
    public List<Pack> recherchpakbyprod(@PathVariable String str){
        return packService.searchpackbyproduit(str);
    }


    @DeleteMapping("/deletepack/{id}")
    public void supprpack(@PathVariable Long id){
        packService.deletepack(id);
    }
    @PostMapping("/updatepack/{id}")
    public  Pack editepack(@PathVariable Long id,@RequestBody Pack pack){
        return packService.updatepack(id,pack);
    }
    @DeleteMapping("/delteprodfpack/{idp}/{idpro}")
    public void suppprodpack(@PathVariable Long idp,@PathVariable Long idpro){
        packService.deletepproduitfpack(idp,idpro);
    }
    @PostMapping("/addprotpack/{idp}/{idpro}")
    public  Pack ajouitprodtopack(@PathVariable Long idp,@PathVariable Long idpro){
        return packService.addprodtopack(idp, idpro);
    }

}
