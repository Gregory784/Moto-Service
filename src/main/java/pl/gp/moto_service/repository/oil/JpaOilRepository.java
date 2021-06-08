package pl.gp.moto_service.repository.oil;


import org.springframework.stereotype.Repository;
import pl.gp.moto_service.entity.Oil;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOilRepository implements OilService {
    private final OilRepository repository;

    public JpaOilRepository(final OilRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Oil> getOils() {
        return repository.findAll();
    }

    @Override
    public void createOil(@Valid final Oil oil) {
        repository.save(oil);
    }

    @Override
    public Optional<Oil> getOilByID(final int id) {
        return repository.findById(id);
    }

    @Override
    public void updateOil(final Oil oil) {
        if(this.getOilByID(oil.getId()).isPresent()){
            repository.save(oil);
        }
    }

    @Override
    public void deleteOilByID(final int id) {
            repository.deleteById(id);
    }
}
