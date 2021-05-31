package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Cformation;

public interface CformationRepo extends JpaRepository<Cformation, Long> {
}
