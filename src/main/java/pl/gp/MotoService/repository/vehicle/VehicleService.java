package pl.gp.MotoService.repository.vehicle;

import pl.gp.MotoService.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> getVehicles();

    void createVehicle(Vehicle vehicle);

    Optional<Vehicle> getVehicleByID(int id);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicleByID(int id);

    List<Vehicle> getVehiclesByArchivesFalse();

    List<Vehicle> getVehiclesByArchivesTrue();

}
