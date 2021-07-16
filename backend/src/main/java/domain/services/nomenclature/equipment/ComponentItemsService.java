package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.equipment.ComponentItemsRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("componentItemsService")
public class ComponentItemsService extends TypoService<ComponentItem> {

    @Autowired
    ComponentItemsRepository repository;

    @Override
    protected TypoRepository<ComponentItem> getRepository() {
        return repository;
    }
}
