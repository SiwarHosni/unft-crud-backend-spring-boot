package spring.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.pfe.entity.Mcredit;

public interface McreditRepo extends JpaRepository<Mcredit, Long> {
}
