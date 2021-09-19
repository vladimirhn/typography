package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentType;
import repository.AbstractTableRepository;
import domain.repositories.nomenclature.equipment.ComponentTypesRepository;
import service.AbstractTableService;
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
