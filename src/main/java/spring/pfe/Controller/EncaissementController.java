package spring.pfe.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import spring.pfe.Service.EncaissementService;
import spring.pfe.entity.Cformation;
import spring.pfe.entity.Encaissement;
import spring.pfe.repository.EncaissementRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EncaissementController {


    @Autowired
    private EncaissementService encaissementService;
    @Autowired
    private EncaissementRepo encaissementRepo;

    @PostMapping("/encaissements")
    public String createEncaissement(@Validated @RequestBody Encaissement e) {
        encaissementService.saveEncaissement(e);
        return "Ajouté avec succès";
    }

    @PutMapping("/encaissements/{id}")
    public String updateEncaissement(@PathVariable(value = "id") Long id, @Validated @RequestBody Encaissement e) {
        Optional<Encaissement> encinfo = encaissementRepo.findById(id);
        if(encinfo.isPresent()) {

            Encaissement enc = encinfo.get();
            enc.setNum_recu(e.getNum_recu());
            enc.setMontant_enc(e.getMontant_enc());
            enc.setDate_enc(e.getDate_enc());
            enc.setMethode_penc(e.getMethode_penc());




            encaissementService.UpdateEncaissement(e);
            return "la mise à jour a été éffectué avec succès";
        }
        else {
            return "Impossible de faire la mise à jour";
        }
    }



    @GetMapping(value ="/encaissements/{id}")
    public Optional<Encaissement> findencaissement(@PathVariable(value ="id") String id) {

        return encaissementService.FindEncaissement(Long.parseLong(id) );
    }

    @GetMapping("/encaissements")
    public List<Encaissement> getallencaissement() {

        return encaissementService.listEncaissements();
    }

    @DeleteMapping(value = "/encaissements/{id}")
    public String deleteencaissement(@PathVariable(value = "id")String id)
    {
        encaissementService.removeEnaissement(Long.parseLong(id));
        return "Enaissement supprimée avec succès";
    }


}
