package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.consumables.ConsumableItemsRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumableItemsService")
public class ConsumableItemsService extends TypoService<ConsumableItem> {

    @Autowired
    ConsumableItemsRepository repository;

    @Override
    protected TypoRepository<ConsumableItem> getRepository() {
        return repository;
    }
}
