package pl.gp.moto_service.repository.tech_review;

import pl.gp.moto_service.entity.TechReview;

import java.util.List;
import java.util.Optional;

public interface TechReviewService {
    List<TechReview> getTechReviews();

    void createTechReviews(TechReview techReview);

    Optional<TechReview> getTechReviewByID(int id);

    void updateTechReviews(TechReview techReview);

    void deleteTechReviewsByID(int id);

    List<TechReview> findTechReviewsByVehicleId(int id);
}
