package domain.services.enterprises;

import domain.models.enterprises.FinancialTransaction;
import domain.repositories.enterprises.FinancialTransactionsViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.v1.AbstractViewRepository;
import service.v1.AbstractViewService;

@Service
public class FinancialTransactionsViewService extends AbstractViewService<FinancialTransaction> {

    @Autowired
    FinancialTransactionsViewRepository repository;

    @Override
    protected AbstractViewRepository<FinancialTransaction> getRepository() {
        return repository;
    }
}
