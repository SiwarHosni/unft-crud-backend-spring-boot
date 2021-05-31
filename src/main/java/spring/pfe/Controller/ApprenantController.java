package spring.pfe.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.pfe.Service.ApprenantService;
import spring.pfe.entity.Apprenant;

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

    @PostMapping("/apprenants")
    public String createApprenant(@Validated @RequestBody Apprenant a) {
        apprenantService.saveApprenant(a);
        return "Ajouté avec succès";
    }

    @PutMapping("/apprenants/{/id}")
    public String updateApprenant(@PathVariable(value = "id") Long medid, @Validated @RequestBody Apprenant a) {
        Apprenant app = apprenantService.UpdateApprenant(a);
        if(app==null) {
            return "Impossible de faire la mise à jour";
        }
        else {
            app.setNomappr(a.getNomappr());
            app.setPrenomappr(a.getPrenomappr());
            app.setDate_naissappr(a.getDate_naissappr());
            app.setSexe(a.getSexe());
            app.setTel(a.getTel());


            apprenantService.UpdateApprenant(a);
            return "la mise à jour a été effectué avec succès";
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

    @DeleteMapping(value = "/deleteapprenant/{id}")
    public String deleteapprenant(@PathVariable(value = "id")String id)
    {
        apprenantService.removeApprenant(Long.parseLong(id));
        return "Apprenant supprimé avec succès";
    }



}

