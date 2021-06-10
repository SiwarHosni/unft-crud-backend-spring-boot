package spring.pfe.Service;

import spring.pfe.entity.Apprenant;

import java.util.List;
import java.util.Optional;

public interface ApprenantService {
    void saveApprenant(Apprenant apprenant);
    Apprenant UpdateApprenant(Apprenant apprenant);
    List<Apprenant> listApprenants();
    void removeApprenant(Long cin);
    public Optional<Apprenant> FindApprenant(Long cin);
}
