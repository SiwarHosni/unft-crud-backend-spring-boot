package spring.pfe.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.pfe.Service.CformationService;
import spring.pfe.entity.Cformation;
import spring.pfe.repository.CformationRepo;

import java.util.List;
import java.util.Optional;

@Service("CformationSImpl")
public class CformationSImpl implements CformationService {


    @Autowired
    CformationRepo cformationRepo;


    @Override
    public void saveCformation(Cformation cformation) {

    }

    @Override
    public Cformation UpdateCformation(Cformation cformation) {
        cformationRepo.save(cformation);
        return cformation;
    }

    @Override
    public List<Cformation> listCformations() {
        return  cformationRepo.findAll();
    }

    @Override
    public void removeCformation(Long id_cf) {
        cformationRepo.deleteById(id_cf);
    }

    @Override
    public Optional<Cformation> FindCformation(Long id_cf) {
        return cformationRepo.findById(id_cf);
    }
}

