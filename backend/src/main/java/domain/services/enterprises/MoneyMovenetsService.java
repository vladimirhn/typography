package domain.services.enterprises;

import domain.models.enterprises.MoneyMovement;
import domain.repositories.enterprises.MoneyMovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractTableRepository;
import service.AbstractTableService;

@Service
public class MoneyMovenetsService extends AbstractTableService<MoneyMovement> {

    @Autowired
    MoneyMovementsRepository repository;
    @Override
    protected AbstractTableRepository<MoneyMovement> getRepository() {
        return repository;
    }

}
