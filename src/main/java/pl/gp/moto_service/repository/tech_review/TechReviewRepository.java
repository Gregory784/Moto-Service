package pl.gp.moto_service.repository.tech_review;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.moto_service.entity.TechReview;

import java.util.List;

public interface TechReviewRepository extends JpaRepository<TechReview, Integer> {
    List<TechReview> findTechReviewsByVehicleId(int id);
}
