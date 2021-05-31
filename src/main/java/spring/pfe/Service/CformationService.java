package spring.pfe.Service;

import spring.pfe.entity.Cformation;

import java.util.List;
import java.util.Optional;

public interface CformationService {
    void saveCformation(Cformation cformation);
    Cformation UpdateCformation(Cformation cformation);
    List<Cformation> listCformations();
    void removeCformation(Long id_cf );
    public Optional<Cformation> FindCformation(Long id_cf);
}
