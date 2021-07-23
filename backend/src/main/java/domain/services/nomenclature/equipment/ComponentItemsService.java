package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.nomenclature.equipment.ComponentItemsRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("componentItemsService")
public class ComponentItemsService extends TypoTableService<ComponentItem> {

    @Autowired
    ComponentItemsRepository repository;

    @Override
    protected TypoTableRepository<ComponentItem> getRepository() {
        return repository;
    }
}
