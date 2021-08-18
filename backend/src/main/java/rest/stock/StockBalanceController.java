package rest.stock;

import domain.models.stock.StockBalance;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;

@RestController
@RequestMapping("/stock_balance")
public class StockBalanceController extends TableController<StockBalance> implements ServiceUser {

    @Override
    protected TypoTableService<StockBalance> getService() {
        return stockBalanceService;
    }

}
