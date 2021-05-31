package spring.pfe.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import spring.pfe.Service.EncaissementService;
import spring.pfe.entity.Encaissement;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EncaissementController {


    @Autowired
    private EncaissementService encaissementService;

    @PostMapping("/encaissements")
    public String createEncaissement(@Validated @RequestBody Encaissement e) {
        encaissementService.saveEncaissement(e);
        return "Ajouté avec succès";
    }

    @PutMapping("/encaissements/{id}")
    public String updateEncaissement(@PathVariable(value = "id") Long medid, @Validated @RequestBody Encaissement e) {
        Encaissement enc = encaissementService.UpdateEncaissement(e);
        if(enc==null) {
            return "Impossible de faire la mise à jour";
        }
        else {
            enc.setNum_recu(e.getNum_recu());
            enc.setMontant_enc(e.getMontant_enc());
            enc.setDate_enc(e.getDate_enc());
            enc.setMethode_penc(e.getMethode_penc());




            encaissementService.UpdateEncaissement(e);
            return "la mise à jour a été éffectué avec succès";
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
