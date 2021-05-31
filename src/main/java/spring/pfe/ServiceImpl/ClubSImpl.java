package spring.pfe.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.pfe.Service.ClubService;
import spring.pfe.entity.Club;
import spring.pfe.repository.ClubRepo;

import java.util.List;
import java.util.Optional;

@Service("ClubSImpl")
public class ClubSImpl implements ClubService {

    @Autowired
    ClubRepo clubRepo;

    @Override
    public void saveClub(Club club) {
        clubRepo.save(club);
        // TODO Auto-generated method stub

    }

    @Override
    public Club UpdateClub(Club club) {
        clubRepo.save(club);
        // TODO Auto-generated method stub
        return club;
    }

    @Override
    public List<Club> listClubs() {
        // TODO Auto-generated method stub
        return clubRepo.findAll();
    }

    @Override
    public void removeClub(Long id_club) {
        clubRepo.deleteById(id_club);
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Club> FindClub(Long id_club) {
        // TODO Auto-generated method stub
        return clubRepo.findById(id_club);
    }

}

