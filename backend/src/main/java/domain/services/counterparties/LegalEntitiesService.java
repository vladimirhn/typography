package domain.services.counterparties;

import domain.models.counterparties.LegalEntity;
import domain.repositories.counterparties.LegalEntitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractTableRepository;
import service.AbstractTableService;

@Service("legalEntitiesService")
public class LegalEntitiesService extends AbstractTableService<LegalEntity> {

    @Autowired
    LegalEntitiesRepository repository;
    @Override
    protected AbstractTableRepository<LegalEntity> getRepository() {
        return repository;
    }

}
