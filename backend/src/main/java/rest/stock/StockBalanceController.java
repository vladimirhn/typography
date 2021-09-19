package rest.stock;

import domain.models.stock.StockBalance;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import rest.response.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping("/stock_balance")
public class StockBalanceController extends TypoTableController<StockBalance> implements TypoServiceUser {

    @Override
    protected AbstractTableService<StockBalance> getService() {
        return stockBalanceService;
    }

    @GetMapping("/get_all_resp")
    public TableDataResponse<StockBalance> getAllResp() {
        return new TableDataResponse<>(getService().selectAll(), getDictionaryService());
    }
}
