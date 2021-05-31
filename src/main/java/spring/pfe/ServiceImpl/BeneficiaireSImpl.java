package spring.pfe.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.pfe.Service.BeneficiaireService;
import spring.pfe.entity.Beneficiaire;
import spring.pfe.repository.BeneficiaireRepo;

import java.util.List;
import java.util.Optional;

@Service("BeneficiaireSImpl")
public class BeneficiaireSImpl implements BeneficiaireService {

    @Autowired
    BeneficiaireRepo beneficiaireRepo;

    @Override
    public void saveBeneficiaire(Beneficiaire beneficiaire) {
        beneficiaireRepo.save(beneficiaire);
        // TODO Auto-generated method stub

    }

    @Override
    public Beneficiaire UpdateBeneficiaire(Beneficiaire beneficiaire) {
        beneficiaireRepo.save(beneficiaire);
        // TODO Auto-generated method stub
        return beneficiaire;
    }

    @Override
    public List<Beneficiaire> listBeneficiaires() {
        beneficiaireRepo.findAll();
        // TODO Auto-generated method stub
        return beneficiaireRepo.findAll();
    }

    @Override
    public void removeBeneficiaire(Long cin) {
        beneficiaireRepo.deleteById(cin);
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Beneficiaire> FindBeneficiaire(Long cin) {
        // TODO Auto-generated method stub
        return beneficiaireRepo.findById(cin);
    }

}
