package pl.gp.moto_service.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.moto_service.entity.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> getVehiclesByArchivesFalse();

    List<Vehicle> getVehiclesByArchivesTrue();
}
