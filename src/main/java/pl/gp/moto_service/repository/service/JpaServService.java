package pl.gp.moto_service.repository.service;

import org.springframework.stereotype.Repository;
import pl.gp.moto_service.entity.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaServService implements ServService{
    private final ServiceRepository serviceRepository;

    public JpaServService(final ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }

    @Override
    public void createService(final Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service getServiceById(final int id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public void updateService(final Service service) {
        if(serviceRepository.findById(service.getId()).isPresent()){
            serviceRepository.save(service);
        }

    }

    @Override
    public void deleteServiceByID(final int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> findAllServiceByVehicleId(final int id) {
        return serviceRepository.findAllServiceByVehicleId(id);
    }

}
