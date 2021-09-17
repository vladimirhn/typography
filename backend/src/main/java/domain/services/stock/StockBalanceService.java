package domain.services.stock;

import domain.models.stock.StockBalance;
import repository.AbstractTableRepository;
import domain.repositories.stock.StockBalanceRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stocBalancekService")
public class StockBalanceService extends TypoTableService<StockBalance> {

    @Autowired
    StockBalanceRepository repository;
    @Override
    protected AbstractTableRepository<StockBalance> getRepository() {
        return repository;
    }

}
