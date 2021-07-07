package pl.gp.moto_service.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gp.moto_service.entity.Oil;
import pl.gp.moto_service.entity.Service;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.repository.service.ServService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceViewModel extends Service {
    private LocalDate dateNextService;
    private int daysToNextService;
    private int mileageToNextService;

    private ServService servService;

    @Autowired
    public ServiceViewModel(final ServService servService) {
        this.servService = servService;
    }
    public ServiceViewModel(){}

    public List<ServiceViewModel> showModelServicesView(int id){
        List<ServiceViewModel> serviceList = new ArrayList<>();
        List<Service> list = servService.findAllServiceByVehicleId(id);
        for (Service serv:list
             ) {
            int expireDays = (int) ChronoUnit.DAYS.between(serv.getServiceData().plusYears(1), LocalDate.now());
            LocalDate endDate = serv.getServiceData().plusYears(serv.getTimeInterval());
            int endKm = (serv.getServiceMileage()+serv.getRunInterval())-serv.getVehicle().getMileage();

            ServiceViewModel toSave = svmBulider().
                    id(serv.getId()).
                    serviceType(serv.getServiceType()).
                    isActiv(serv.isActive()).
                    serviceData(serv.getServiceData()).
                    serviceMileage(serv.getServiceMileage()).
                    runInterval(serv.getRunInterval()).
                    timeInterval(serv.getTimeInterval()).
                    quantity(serv.getQuantity()).
                    serviceCost(serv.getServiceCost()).
                    vehicle(serv.getVehicle()).
                    oil(serv.getOil()).
                    dateNextService(endDate).
                    daysToNextService(expireDays*(-1)).
                    mileageToNextService(endKm).
                    build();
            serviceList.add(toSave);
        }
        return serviceList;
    }

    @Builder(builderMethodName = "svmBulider")
    public ServiceViewModel (int id, String serviceType, boolean isActiv, LocalDate serviceData, int serviceMileage, int runInterval, int timeInterval, double quantity, double serviceCost, Vehicle vehicle, Oil oil, LocalDate dateNextService, int daysToNextService, int mileageToNextService){
        super(id, serviceType, isActiv, serviceData, serviceMileage, runInterval, timeInterval, quantity, serviceCost, vehicle, oil);
      this.dateNextService=dateNextService;
      this.daysToNextService=daysToNextService;
      this.mileageToNextService=mileageToNextService;
    }
}
