package pl.gp.moto_service.repository.insurance;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.moto_service.entity.Insurance;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

    List<Insurance> getInsuranceByVehicle_Id(int id);
}
