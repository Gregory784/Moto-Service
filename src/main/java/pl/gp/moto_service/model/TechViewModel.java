package pl.gp.moto_service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gp.moto_service.entity.Insurance;
import pl.gp.moto_service.entity.TechReview;
import pl.gp.moto_service.repository.insurance.TechReviewServices;
import pl.gp.moto_service.repository.tech_review.TechReviewService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Component
@Data
public class TechViewModel extends TechReview{


    private int expireDay;
    private LocalDate endData;

    private TechReviewService techReviewService;

    @Autowired
    public TechViewModel(final TechReviewService techReviewService) {
        this.techReviewService = techReviewService;
    }
    public TechViewModel(){};


    public List<TechViewModel> showInsurances(int id) {
        List<TechReview> techReviews = techReviewService.findTechReviewsByVehicleId(id);
        List<TechViewModel> viewList = new ArrayList<>();
        for (TechReview item : techReviews
        ) {
            int expire = (int) ChronoUnit.DAYS.between(item.getReleaseData().plusYears(1), LocalDate.now());
            TechViewModel techViewModel = new TechViewModel();
            techViewModel.setId(item.getId());
            techViewModel.setReleaseData(item.getReleaseData());
            techViewModel.setCosts(item.getCosts());
            techViewModel.setExpireDay(expire*(-1));
            techViewModel.setEndData(item.getReleaseData().plusYears(1));
            viewList.add(techViewModel);
        }
        return viewList;
    }
}