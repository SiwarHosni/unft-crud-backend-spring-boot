package spring.pfe.Service;

import spring.pfe.entity.Club;

import java.util.List;
import java.util.Optional;

public interface ClubService {

    void saveClub(Club club);
    Club UpdateClub(Club club);
    List<Club> listClubs();
    void removeClub(Long id_club );
    public Optional<Club> FindClub(Long id_club);
}
