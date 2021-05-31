package spring.pfe.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.pfe.Service.ProjetService;
import spring.pfe.entity.Projet;
import spring.pfe.repository.ProjetRepo;

import java.util.List;
import java.util.Optional;

@Service("ProjetSImpl")
public class ProjetSImpl implements ProjetService {

    @Autowired
    ProjetRepo projetRepo;

    @Override
    public void saveProjet(Projet projet) {
        projetRepo.save(projet);
        // TODO Auto-generated method stub

    }

    @Override
    public Projet UpdateProjet(Projet projet) {
        projetRepo.save(projet);
        // TODO Auto-generated method stub
        return projet;
    }

    @Override
    public List<Projet> listProjets() {
        // TODO Auto-generated method stub
        return projetRepo.findAll();
    }

    @Override
    public void removeProjet(Long Id_projet) {
        projetRepo.deleteById(Id_projet);
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Projet> FindProjet(Long Id_projet) {
        // TODO Auto-generated method stub
        return projetRepo.findById(Id_projet);
    }

}
