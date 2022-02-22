package domain.services.enterprises;

import domain.models.enterprises.Enterprise;
import domain.repositories.enterprises.EnterprisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AbstractTableRepository;
import service.AbstractTableService;

public class EnterprisesService extends AbstractTableService<Enterprise> {

    @Autowired
    EnterprisesRepository repository;
    @Override
    protected AbstractTableRepository<Enterprise> getRepository() {
        return repository;
    }

}
