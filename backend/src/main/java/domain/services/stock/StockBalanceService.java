package domain.services.stock;

import domain.models.stock.StockBalance;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.stock.StockBalanceRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stockService")
public class StockBalanceService extends TypoTableService<StockBalance> {

    @Autowired
    StockBalanceRepository repository;
    @Override
    protected TypoTableRepository<StockBalance> getRepository() {
        return repository;
    }

}
