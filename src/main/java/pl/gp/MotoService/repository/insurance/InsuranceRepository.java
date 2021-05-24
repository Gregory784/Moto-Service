package pl.gp.MotoService.repository.insurance;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.MotoService.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
