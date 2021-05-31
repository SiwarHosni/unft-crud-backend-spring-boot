package spring.pfe.Service;

import spring.pfe.entity.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {
    void saveFormation(Formation formation);
    Formation UpdateFormation(Formation formation);
    List<Formation> listFormations();
    void removeFormation(Long Id_formation );
    public Optional<Formation> FindFormation(Long id_formation);
}
