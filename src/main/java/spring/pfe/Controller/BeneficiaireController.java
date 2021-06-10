package spring.pfe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.pfe.Service.BeneficiaireService;
import spring.pfe.entity.Apprenant;
import spring.pfe.entity.Beneficiaire;
import spring.pfe.repository.BeneficiaireRepo;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BeneficiaireController {

    @Autowired
    private BeneficiaireService beneficiaireService;
    @Autowired
    private BeneficiaireRepo beneficiaireRepo;

    @PostMapping("/beneficiaires")
    public String createBeneficiaire(@Validated @RequestBody Beneficiaire b) {
        beneficiaireService.saveBeneficiaire(b);
        return "Ajouté avec succès.";
    }

    @PutMapping("/beneficiaires/{id}")
    public String updateBeneficiaire(@PathVariable(value = "id") Long id, @Validated @RequestBody Beneficiaire b) {
        Optional<Beneficiaire> benefinfo = beneficiaireRepo.findById(id);
        if(benefinfo.isPresent()) {

            Beneficiaire bene = benefinfo.get();
            bene.setLieu_cin(b.getLieu_cin());
            bene.setDate_emission(b.getDate_emission());
            bene.setNomb(b.getNomb());
            bene.setPrenomb(b.getPrenomb());
            bene.setDate_naissance(b.getDate_naissance());
            bene.setAdresse(b.getAdresse());
            bene.setGouv_b(b.getGouv_b());
            bene.setDelegation(b.getDelegation());
            bene.setSexe(b.getSexe());
            bene.setTel(b.getTel());
            bene.setNiveau_ed(b.getNiveau_ed());
            bene.setProfession(b.getProfession());
            bene.setDuree_experience(b.getDuree_experience());
            bene.setLogement(b.getLogement());
            bene.setSrc_rev_b(b.getSrc_rev_b());
            bene.setMm_rev_b(b.getMm_rev_b());
            bene.setSrc_rev_fam_b(b.getSrc_rev_fam_b());
            bene.setSrc_rev_fam_b(b.getSrc_rev_fam_b());
            bene.setNom_banque(b.getNom_banque());
            bene.setRib(b.getRib());



            beneficiaireService.UpdateBeneficiaire(b);
            return "la mise à jour a été éffectué avec succès.";
        }
        {

            return "Impossible de faire la mise à jour !";
        }
    }

    @GetMapping(value ="/beneficiaires/{id}")
    public Optional<Beneficiaire> findbeneficiaire(@PathVariable(value ="id") String id) {

        return beneficiaireService.FindBeneficiaire(Long.parseLong(id) );
    }

    @GetMapping("/beneficiaires")
    public List<Beneficiaire> getallbeneficiaire() {

        return beneficiaireService.listBeneficiaires();
    }

    @DeleteMapping(value = "/beneficiaires/{id}")
    public String deletbeneficiaire(@PathVariable(value = "id")String id)
    {
        beneficiaireService.removeBeneficiaire(Long.parseLong(id));
        return "Beneficiaire supprimé avec succès.";
    }

}

