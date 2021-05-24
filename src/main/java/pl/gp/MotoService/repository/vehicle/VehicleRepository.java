package pl.gp.MotoService.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.MotoService.entity.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> getVehiclesByArchivesFalse();

    List<Vehicle> getVehiclesByArchivesTrue();
}
