package domain.services.stock;

import domain.models.stock.OrderConsumedConsumablesBalanceView;
import domain.models.stock.PurchasedConsumablesBalanceView;
import domain.models.stock.StockBalance;
import domain.services.abstracts.TypoServiceUser;
import kcollections.KList;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Service("stockBalanceService")
public class StockBalanceService implements TypoServiceUser {

    public Set<StockBalance> getStockBalance() {
        KList<PurchasedConsumablesBalanceView> purchased = purchasedConsumablesBalanceViewService.selectAll();
        KList<OrderConsumedConsumablesBalanceView> orderConsumed = orderConsumedConsumablesBalanceViewService.selectAll();

        Map<String, StockBalance> resultMap = new HashMap<>();
        purchased.forEach(purch -> resultMap.put(purch.getItemId(), purch.toStockBalance()));

        orderConsumed.forEach(ordCons -> {
            String itemId = ordCons.getItemId();

            if (resultMap.get(itemId) != null) {
                StockBalance line = resultMap.get(itemId);
                line.setSum(line.getSum().subtract(ordCons.getSum()));
            } else {
                StockBalance line = ordCons.toStockBalance();
                line.setSum(line.getSum().negate());
                resultMap.put(ordCons.getItemId(), line);
            }
        });

        return new TreeSet<>(resultMap.values());
    }

}
