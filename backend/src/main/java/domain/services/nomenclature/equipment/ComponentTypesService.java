package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentType;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.equipment.ComponentTypesRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("componentTypesService")
public class ComponentTypesService extends TypoService<ComponentType> {

    @Autowired
    ComponentTypesRepository repository;

    @Override
    protected TypoRepository<ComponentType> getRepository() {
        return repository;
    }
}
