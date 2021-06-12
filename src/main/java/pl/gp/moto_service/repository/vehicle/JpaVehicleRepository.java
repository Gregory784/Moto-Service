package pl.gp.moto_service.repository.vehicle;

import org.springframework.stereotype.Repository;
import pl.gp.moto_service.entity.Vehicle;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaVehicleRepository implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public JpaVehicleRepository(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void createVehicle(final Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> getVehicleByID(final int id) {
        return this.vehicleRepository.findById(id);
    }

    @Override
    public void updateVehicle(final Vehicle vehicle) {
        if (this.getVehicleByID(vehicle.getId()).isPresent()) {
            vehicleRepository.save(vehicle);
        }
    }

    @Override
    public void deleteVehicleByID(final int id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getVehiclesByArchivesFalse() {
        return vehicleRepository.getVehiclesByArchivesFalse();
    }

    @Override
    public List<Vehicle> getVehiclesByArchivesTrue() {
        return vehicleRepository.getVehiclesByArchivesTrue();
    }


}
