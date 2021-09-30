package domain.services.orders;

import domain.models.orders.Parameter;
import domain.repositories.orders.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractTableRepository;
import service.AbstractTableService;

@Service("parameterService")
public class ParameterService extends AbstractTableService<Parameter> {

    @Autowired
    ParameterRepository repository;
    @Override
    protected AbstractTableRepository<Parameter> getRepository() {
        return repository;
    }

}
