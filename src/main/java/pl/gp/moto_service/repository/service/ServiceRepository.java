package pl.gp.moto_service.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.moto_service.entity.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findAllServiceByVehicleId(int id);
    Service getServiceById(int id);
}
