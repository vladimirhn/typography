package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import repository.v1.AbstractTableRepository;
import domain.repositories.nomenclature.equipment.ComponentItemsRepository;
import service.v1.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("componentItemsService")
public class ComponentItemsService extends AbstractTableService<ComponentItem> {

    @Autowired
    ComponentItemsRepository repository;

    @Override
    protected AbstractTableRepository<ComponentItem> getRepository() {
        return repository;
    }
}
