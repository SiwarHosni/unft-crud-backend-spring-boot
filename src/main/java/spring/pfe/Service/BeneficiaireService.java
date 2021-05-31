package spring.pfe.Service;

import spring.pfe.entity.Beneficiaire;

import java.util.List;
import java.util.Optional;

public interface BeneficiaireService {
    void saveBeneficiaire(Beneficiaire beneficiaire);
    Beneficiaire UpdateBeneficiaire(Beneficiaire beneficiaire);
    List<Beneficiaire> listBeneficiaires();
    void removeBeneficiaire(Long cin );
    public Optional<Beneficiaire> FindBeneficiaire(Long cin);
}
