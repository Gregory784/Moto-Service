package pl.gp.moto_service.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gp.moto_service.entity.Service;
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

            ServiceViewModel current = new ServiceViewModel();
            current.setId(serv.getId());
            current.setServiceType(serv.getServiceType());
            current.setActive(serv.isActive());
            current.setServiceData(serv.getServiceData());
            current.setServiceMileage(serv.getServiceMileage());
            current.setRunInterval(serv.getRunInterval());
            current.setTimeInterval(serv.getTimeInterval());
            current.setServiceCost(serv.getServiceCost());
            current.setVehicle(serv.getVehicle());
            current.setOil(serv.getOil());
            current.setDateNextService(endDate);
            current.setDaysToNextService(expireDays*(-1));
            current.setMileageToNextService(endKm);

            serviceList.add(current);
        }
        //serviceList.sort(Comparator.comparingInt(OilServiceModel::getDaysToNextService));
        return serviceList;
    }
}
