package pl.gp.moto_service.repository.insurance;

import pl.gp.moto_service.entity.Insurance;

import java.util.List;
import java.util.Optional;

public interface InsuranceServices {
    List<Insurance> getInsurance();

    void createInsurance(Insurance insurance);

    Optional<Insurance> getInsuranceByID(int id);

    void updateInsurance(Insurance insurance);

    void deleteInsuranceByID(int id);

    List<Insurance> getInsuranceByVehicle_Id(int id);
}
