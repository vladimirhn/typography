package domain.services.stock;

import domain.models.stock.Stock;
import repository.v1.AbstractTableRepository;
import domain.repositories.stock.StockRepository;
import service.v1.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stockService")
public class StockService extends AbstractTableService<Stock> {

    @Autowired
    StockRepository repository;
    @Override
    protected AbstractTableRepository<Stock> getRepository() {
        return repository;
    }

}
