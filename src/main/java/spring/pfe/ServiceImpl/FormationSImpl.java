package spring.pfe.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.pfe.Service.FormationService;
import spring.pfe.entity.Formation;
import spring.pfe.repository.FormationRepo;

import java.util.List;
import java.util.Optional;

@Service("FormationSImpl")
public class FormationSImpl implements FormationService {

    @Autowired
    FormationRepo formationRepo;

    @Override
    public void saveFormation(Formation formation) {
        formationRepo.save(formation);
        // TODO Auto-generated method stub

    }

    @Override
    public Formation UpdateFormation(Formation formation) {
        formationRepo.save(formation);
        // TODO Auto-generated method stub
        return formation;
    }

    @Override
    public List<Formation> listFormations() {
        // TODO Auto-generated method stub
        return formationRepo.findAll();
    }

    @Override
    public void removeFormation(Long Id_formation) {
        formationRepo.deleteById(Id_formation);
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Formation> FindFormation(Long id_formation) {
        // TODO Auto-generated method stub
        return formationRepo.findById(id_formation);
    }

}

