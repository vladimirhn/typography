package rest.stock;

import domain.models.stock.StockBalance;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import kcollections.KList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;
import rest.responses.TableDataResponse;

@RestController
@RequestMapping("/stock_balance")
public class StockBalanceController extends TableController<StockBalance> implements ServiceUser {

    @Override
    protected TypoTableService<StockBalance> getService() {
        return stockBalanceService;
    }

    @GetMapping("/get_all_resp")
    public TableDataResponse<StockBalance> getAllResp() {
        return new TableDataResponse<>(getService().selectAll());
    }
}
