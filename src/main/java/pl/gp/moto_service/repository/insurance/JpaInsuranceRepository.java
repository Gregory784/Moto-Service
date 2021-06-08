package pl.gp.moto_service.repository.insurance;

import org.springframework.stereotype.Repository;
import pl.gp.moto_service.entity.Insurance;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaInsuranceRepository implements TechReviewServices {

    private InsuranceRepository insuranceRepository;

    public JpaInsuranceRepository(final InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public List<Insurance> getInsurance() {
        return insuranceRepository.findAll();
    }

    @Override
    public void createInsurance(final Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    @Override
    public Optional<Insurance> getInsuranceByID(final int id) {
        return this.insuranceRepository.findById(id);
    }

    @Override
    public void updateInsurance(final Insurance insurance) {
        if(insuranceRepository.findById(insurance.getId()).isPresent()){
            insuranceRepository.save(insurance);
        }

    }

    @Override
    public void deleteInsuranceByID(final int id) {
        insuranceRepository.deleteById(id);
    }

    @Override
    public List<Insurance> getInsuranceByVehicle_Id(final int id) {
        return insuranceRepository.getInsuranceByVehicle_Id(id);
    }

}
