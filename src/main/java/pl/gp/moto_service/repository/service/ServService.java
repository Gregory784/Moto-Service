package pl.gp.moto_service.repository.service;

import pl.gp.moto_service.entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServService {

    List<Service> getServices();

    void createService(Service service);

    Service getServiceById(int id);

    void updateService(Service service);

    void deleteServiceByID(int id);

    List<Service> findAllServiceByVehicleId(int id);
}
