package rest.stock;

import domain.models.stock.StockBalance;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.response.tables.TableDataResponse;

@RestController
@RequestMapping("/u/stock_balance")
public class StockBalanceController implements TypoServiceUser {

    @GetMapping("/get_all")
    public TableDataResponse<StockBalance> getAllResp() {
        return new TableDataResponse<>(stockBalanceService.getStockBalance(), typoDictionaryService);
    }
}
