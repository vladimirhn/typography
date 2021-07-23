package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentType;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.nomenclature.equipment.ComponentTypesRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("componentTypesService")
public class ComponentTypesService extends TypoTableService<ComponentType> {

    @Autowired
    ComponentTypesRepository repository;

    @Override
    protected TypoTableRepository<ComponentType> getRepository() {
        return repository;
    }
}
