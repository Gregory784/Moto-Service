package pl.gp.moto_service.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.gp.moto_service.entity.Insurance;
import pl.gp.moto_service.entity.Service;
import pl.gp.moto_service.entity.TechReview;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.repository.insurance.InsuranceServices;
import pl.gp.moto_service.repository.service.ServService;
import pl.gp.moto_service.repository.tech_review.TechReviewService;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Component
@Data
public class DetailsVehicleViewModel {
    private final VehicleService vehicleService;
    private final TechReviewService techReviewService;
    private final InsuranceServices insuranceServices;
    private final ServService servService;

    public int distance(int id){
        if (vehicleService.getVehicleByID(id).isPresent()){
            Vehicle current = vehicleService.getVehicleByID(id).get();
            return current.getMileage() - current.getInitialMileage();
        }
        return 0;
    }

    public String useTime(int id){
        if (vehicleService.getVehicleByID(id).isPresent()){
            Vehicle current = vehicleService.getVehicleByID(id).get();
            Period useTime = Period.between(current.getPurchaseData(),LocalDate.now());

            return String.format("%s days, %s months and %s years",
                    useTime.getDays(),useTime.getMonths(),useTime.getYears());
        }
        return "The vehicle does not exist";
    }

    public double serviceCosts(int id){
        if (vehicleService.getVehicleByID(id).isPresent()) {
            Vehicle current = vehicleService.getVehicleByID(id).get();
            List<Insurance> insuranceList = insuranceServices.getInsuranceByVehicle_Id(id);
            List<TechReview> techReviewList = techReviewService.findTechReviewsByVehicleId(id);
            List<Service> serviceList = servService.findAllServiceByVehicleId(id);
            double insuranceCost = 0;
            double techCost = 0;
            double serviceCost = 0;
            for (Insurance item: insuranceList
                 ) {
                insuranceCost += item.getCosts();
            }
            for (TechReview item: techReviewList
                 ) {
                techCost += item.getCosts();
            }
            for (Service serv: serviceList
                 ) {
                serviceCost += serv.getServiceCost();
            }
            return insuranceCost + techCost + serviceCost;
        }
        return 0;
    }
}
