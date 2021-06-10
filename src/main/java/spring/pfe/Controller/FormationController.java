package spring.pfe.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import spring.pfe.Service.FormationService;
import spring.pfe.entity.Beneficiaire;
import spring.pfe.entity.Formation;
import spring.pfe.repository.FormationRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FormationController {

    @Autowired
    private FormationService formationService;
    @Autowired
    private FormationRepo formationRepo;

    @PostMapping("/formations")
    public String createFormation(@Validated @RequestBody Formation f) {
        formationService.saveFormation(f);
        return "Ajouté avec succès";
    }

    @PutMapping("/formations/{id}")
    public String updateFormation(@PathVariable(value = "id") Long id, @Validated @RequestBody Formation f) {
        Optional<Formation> forminfo = formationRepo.findById(id);
        if(forminfo.isPresent()) {

            Formation form = forminfo.get();
            form.setNom_formation(f.getNom_formation());
            form.setSpecialite(f.getSpecialite());
            form.setDuree_formation(f.getDuree_formation());
            form.setNbr_apprenant(f.getNbr_apprenant());
            form.setCollab(f.getCollab());
            form.setAge(f.getAge());
            form.setFormation_sexe(f.getFormation_sexe());




            formationService.UpdateFormation(f);
            return "la mise à jour a été éffectué avec succès.";
        }
        else{
            return "Impossible de faire la mise à jour !";
        }
    }



    @GetMapping(value ="/formations/{id}")
    public Optional<Formation> findformation(@PathVariable(value ="id") String id) {

        return formationService.FindFormation(Long.parseLong(id) );
    }

    @GetMapping("/formations")
    public List<Formation> getallformation() {

        return formationService.listFormations();
    }

    @DeleteMapping(value = "/formations/{id}")
    public String deleteformation(@PathVariable(value = "id")String id)
    {
        formationService.removeFormation(Long.parseLong(id));
        return "Formation supprimée avec succès";
    }


}
