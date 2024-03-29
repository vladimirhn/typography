package domain.models.stock;

import kpersistence.annotations.Column;
import kpersistence.annotations.Table;
import kpersistence.tables.UserIdView;

import java.math.BigDecimal;

@Table(name = "ORDER_CONSUMED_CONSUMABLES_BALANCE_VIEW")
public class OrderConsumedConsumablesBalanceView extends UserIdView {

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ITEM_ID")
    String itemId;

    @Column(name = "ITEM")
    String item;

    @Column(name = "SUM")
    BigDecimal sum;

    public StockBalance toStockBalance() {
        return new StockBalance(itemId, item, getSum(), BigDecimal.ONE);
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getSum() {
        return sum == null ? BigDecimal.ZERO : sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
