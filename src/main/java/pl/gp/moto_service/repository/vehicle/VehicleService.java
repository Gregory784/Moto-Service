package pl.gp.moto_service.repository.vehicle;

import pl.gp.moto_service.entity.Vehicle;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> getVehicles();

    void createVehicle(@Valid Vehicle vehicle);

    Optional<Vehicle> getVehicleByID(int id);

    void updateVehicle(@Valid Vehicle vehicle);

    void deleteVehicleByID(int id);

    List<Vehicle> getVehiclesByArchivesFalse();

    List<Vehicle> getVehiclesByArchivesTrue();

}
