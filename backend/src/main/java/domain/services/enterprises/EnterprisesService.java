package domain.services.enterprises;

import domain.models.enterprises.Enterprise;
import domain.repositories.enterprises.EnterprisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.v1.AbstractTableRepository;
import service.v1.AbstractTableService;

@Service
public class EnterprisesService extends AbstractTableService<Enterprise> {

    @Autowired
    EnterprisesRepository repository;
    @Override
    protected AbstractTableRepository<Enterprise> getRepository() {
        return repository;
    }

}
