package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Club;

public interface ClubRepo extends JpaRepository<Club, Long> {
}
