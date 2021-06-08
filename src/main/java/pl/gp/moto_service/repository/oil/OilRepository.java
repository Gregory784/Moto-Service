package pl.gp.moto_service.repository.oil;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.moto_service.entity.Oil;

public interface OilRepository extends JpaRepository<Oil, Integer> {
}
