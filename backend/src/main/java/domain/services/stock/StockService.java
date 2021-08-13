package domain.services.stock;

import domain.models.stock.Stock;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.stock.StockRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stockService")
public class StockService extends TypoTableService<Stock> {

    @Autowired
    StockRepository repository;
    @Override
    protected TypoTableRepository<Stock> getRepository() {
        return repository;
    }

}
