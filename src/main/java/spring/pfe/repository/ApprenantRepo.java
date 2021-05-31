package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Apprenant;

public interface ApprenantRepo extends JpaRepository<Apprenant, Long> {
}
