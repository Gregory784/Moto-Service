package pl.gp.moto_service.repository.oil;

import pl.gp.moto_service.entity.Oil;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface OilService {
    List<Oil> getOils();

    void createOil(@Valid Oil oil);

    Optional<Oil> getOilByID(int id);

    void updateOil(Oil oil);

    void deleteOilByID(int id);
}
