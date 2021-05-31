package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Formation;

public interface FormationRepo extends JpaRepository<Formation, Long> {
}
