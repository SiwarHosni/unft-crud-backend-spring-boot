package spring.pfe.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.pfe.Service.ApprenantService;
import spring.pfe.entity.Apprenant;
import spring.pfe.entity.Club;
import spring.pfe.repository.ApprenantRepo;


import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;
    @Autowired
    private ApprenantRepo apprenantRepo;

    @PostMapping("/apprenants")
    public String createApprenant(@Validated @RequestBody Apprenant a) {
        apprenantService.saveApprenant(a);
        return "Ajouté avec succès.";
    }

    @PutMapping("/apprenants/{/id}")
    public String updateApprenant(@PathVariable(value = "id") Long id, @Validated @RequestBody Apprenant a) {
        Optional<Apprenant> apprinfo = apprenantRepo.findById(id);
        if(apprinfo.isPresent()) {

            Apprenant app = apprinfo.get();
            app.setNomappr(a.getNomappr());
            app.setPrenomappr(a.getPrenomappr());
            app.setDate_naissappr(a.getDate_naissappr());
            app.setSexe(a.getSexe());
            app.setTel(a.getTel());


            apprenantService.UpdateApprenant(a);
            return "la mise à jour a été effectué avec succès.";
        }
        else {
            return "Impossible de faire la mise à jour !";
        }

    }


    @GetMapping(value ="/apprenants/{id}")
    public Optional<Apprenant> findappprenant(@PathVariable(value ="id") String id) {

        return apprenantService.FindApprenant(Long.parseLong(id) );
    }

    @GetMapping("/apprenants")
    public List<Apprenant> getallapprenant() {

        return apprenantService.listApprenants();
    }

    @DeleteMapping(value = "/apprenants/{id}")
    public String deleteapprenant(@PathVariable(value = "id")String id)
    {
        apprenantService.removeApprenant(Long.parseLong(id));
        return "Apprenant supprimé avec succès.";
    }



}

