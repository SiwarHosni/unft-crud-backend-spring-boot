package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Projet;

public interface ProjetRepo extends JpaRepository<Projet, Long> {
}
