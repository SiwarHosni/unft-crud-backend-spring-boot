package spring.pfe.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import spring.pfe.Service.ProjetService;
import spring.pfe.entity.Mcredit;
import spring.pfe.entity.Projet;
import spring.pfe.repository.ProjetRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjetController {


    @Autowired
    private ProjetService projetService;
    @Autowired
    private ProjetRepo projetRepo;

    @PostMapping("/projets")
    public String createProjet(@Validated @RequestBody Projet p) {
        projetService.saveProjet(p);
        return "Ajouté avec succès";
    }

    @PutMapping("/projets/{id}")
    public String updateProjet(@PathVariable(value = "id") Long id, @Validated @RequestBody Projet p) {
        Optional<Projet> projetinfo = projetRepo.findById(id);
        if(projetinfo.isPresent())
        {
            Projet proj = projetinfo.get();
            proj.setType_projet(p.getType_projet());
            proj.setSect_act(p.getSect_act());
            proj.setType_act(p.getType_act());
            proj.setAdresse_projet(p.getAdresse_projet());
            proj.setType_fin(p.getType_fin());
            proj.setMontant_dm(p.getMontant_dm());
            proj.setMontanttr(p.getMontanttr());
            proj.setDuree_paiement(p.getDuree_paiement());
            proj.setDate_dm(p.getDate_dm());


            projetService.UpdateProjet(p);
            return "la mise à jour a été éffectué avec succès.";
        }
        else{
            return "Impossible de faire la mise à jour !";
        }
    }



    @GetMapping(value ="/projets/{id}")
    public Optional<Projet> findprojet(@PathVariable(value ="id") String id) {

        return projetService.FindProjet(Long.parseLong(id) );
    }

    @GetMapping("/projets")
    public List<Projet> getallprojet() {

        return projetService.listProjets();
    }

    @DeleteMapping(value = "/projets/{id}")
    public String deletecprojet(@PathVariable(value = "id")String id)
    {
        projetService.removeProjet(Long.parseLong(id));
        return "Projet supprimé avec succès";
    }


}
