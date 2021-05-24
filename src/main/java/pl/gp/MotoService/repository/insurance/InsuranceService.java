package pl.gp.MotoService.repository.insurance;

import pl.gp.MotoService.entity.Insurance;

import java.util.List;
import java.util.Optional;

public interface InsuranceService {
    List<Insurance> getInsurance();

    void createInsurance(Insurance insurance);

    Optional<Insurance> getInsuranceByID(int id);

    void updateInsurance(Insurance insurance);

    void deleteInsuranceByID(int id);
}
