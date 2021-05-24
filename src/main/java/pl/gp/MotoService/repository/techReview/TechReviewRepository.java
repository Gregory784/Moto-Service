package pl.gp.MotoService.repository.techReview;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.MotoService.entity.TechReview;

public interface TechReviewRepository extends JpaRepository<TechReview, Integer> {
}
