package pl.gp.moto_service.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gp.moto_service.entity.Insurance;
import pl.gp.moto_service.repository.insurance.TechReviewServices;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Component
@Data
public class InsuranceViewModel extends Insurance{
    private int expireDay;

    private TechReviewServices insuranceService;

    @Autowired
    public InsuranceViewModel(final TechReviewServices insuranceService) {
        this.insuranceService = insuranceService;
    }
    public InsuranceViewModel(){};


    public List<InsuranceViewModel> showInsurances(int id) {
        List<Insurance> insuranceList = insuranceService.getInsuranceByVehicle_Id(id);
        List<InsuranceViewModel> viewList = new ArrayList<>();
        for (Insurance item : insuranceList
        ) {
            int expire = (int) ChronoUnit.DAYS.between(item.getReleaseData().plusYears(1), LocalDate.now().minusDays(1));
            InsuranceViewModel insuranceViewModel = new InsuranceViewModel();
            insuranceViewModel.setId(item.getId());
            insuranceViewModel.setName(item.getName());
            insuranceViewModel.setReleaseData(item.getReleaseData());
            insuranceViewModel.setInsuranceNumber(item.getInsuranceNumber());
            insuranceViewModel.setCosts(item.getCosts());
            insuranceViewModel.setExpireDay(expire*(-1));
            viewList.add(insuranceViewModel);
        }
        System.out.println(viewList.toString());
        return viewList;
    }
}