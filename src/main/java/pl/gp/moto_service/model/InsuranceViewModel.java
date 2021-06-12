package pl.gp.moto_service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gp.moto_service.entity.Insurance;
import pl.gp.moto_service.repository.insurance.InsuranceServices;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@EqualsAndHashCode(callSuper = true)
@Component
@Data
public class InsuranceViewModel extends Insurance{
    private int expireDay;
    private boolean active = true;
    private LocalDate endDate;

    private InsuranceServices insuranceService;

    @Autowired
    public InsuranceViewModel(final InsuranceServices insuranceService) {
        this.insuranceService = insuranceService;
    }
    public InsuranceViewModel(){};



    public List<InsuranceViewModel> showAllList(int id) {
        List<Insurance> insuranceList = insuranceService.getInsuranceByVehicle_Id(id);
        List<InsuranceViewModel> viewList = new ArrayList<>();

        for (Insurance item : insuranceList
        ) {
            int expire = (int) ChronoUnit.DAYS.between(item.getReleaseData().plusYears(1), LocalDate.now().minusDays(1));
            LocalDate end = item.getReleaseData().plusYears(1);
            InsuranceViewModel insuranceViewModel = new InsuranceViewModel();
            insuranceViewModel.setId(item.getId());
            insuranceViewModel.setName(item.getName());
            insuranceViewModel.setReleaseData(item.getReleaseData());
            insuranceViewModel.setInsuranceNumber(item.getInsuranceNumber());
            insuranceViewModel.setCosts(item.getCosts());
            if(expire < 0){
                insuranceViewModel.setActive(false);
            }
            insuranceViewModel.setExpireDay(expire*(-1));
            insuranceViewModel.setEndDate(end.minusDays(1));
            viewList.add(insuranceViewModel);
        }
        return viewList;
    }

    public List<InsuranceViewModel> activeList(int id){
        return showAllList(id).stream().filter(e -> !e.isActive()).collect(Collectors.toList());
    }
}