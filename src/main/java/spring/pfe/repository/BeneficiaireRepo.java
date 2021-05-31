package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Beneficiaire;

public interface BeneficiaireRepo extends JpaRepository<Beneficiaire, Long> {
}
