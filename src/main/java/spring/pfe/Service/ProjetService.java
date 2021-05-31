package spring.pfe.Service;

import spring.pfe.entity.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjetService {
    void saveProjet(Projet projet);
    Projet UpdateProjet(Projet projet);
    List<Projet> listProjets();
    void removeProjet(Long Id_projet );
    public Optional<Projet> FindProjet(Long Id_projet);
}
