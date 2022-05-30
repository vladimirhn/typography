package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentType;
import repository.v1.AbstractTableRepository;
import domain.repositories.nomenclature.equipment.ComponentTypesRepository;
import service.v1.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("componentTypesService")
public class ComponentTypesService extends AbstractTableService<ComponentType> {

    @Autowired
    ComponentTypesRepository repository;

    @Override
    protected AbstractTableRepository<ComponentType> getRepository() {
        return repository;
    }
}
