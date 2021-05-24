package pl.gp.MotoService.repository.techReview;

import pl.gp.MotoService.entity.Insurance;
import pl.gp.MotoService.entity.TechReview;

import java.util.List;
import java.util.Optional;

public interface TechReviewService {
    List<TechReview> getTechReviews();

    void createTechReviews(TechReview techReview);

    Optional<TechReview> getTechReviewByID(int id);

    void updateTechReviews(TechReview techReview);

    void deleteTechReviewsByID(int id);
}
