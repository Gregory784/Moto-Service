package pl.gp.MotoService.repository.techReview;

import org.springframework.stereotype.Repository;
import pl.gp.MotoService.entity.TechReview;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaTechReviewRepository implements TechReviewService{
    private TechReviewRepository techReviewRepository;

    public JpaTechReviewRepository(final TechReviewRepository techReviewRepository) {
        this.techReviewRepository = techReviewRepository;
    }


    @Override
    public List<TechReview> getTechReviews() {
        return techReviewRepository.findAll();
    }

    @Override
    public void createTechReviews(final TechReview techReview) {
        techReviewRepository.save(techReview);
    }

    @Override
    public Optional<TechReview> getTechReviewByID(final int id) {
        return this.techReviewRepository.findById(id);
    }

    @Override
    public void updateTechReviews(final TechReview techReview) {
        if(techReviewRepository.findById(techReview.getId()).isPresent()){
            techReviewRepository.save(techReview);
        }
    }

    @Override
    public void deleteTechReviewsByID(final int id) {
        techReviewRepository.deleteById(id);
    }
}
