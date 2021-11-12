package domain.models.stock;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;
import repository.tables.UserIdAbstractView;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_CONSUMED_CONSUMABLES_BALANCE_VIEW")
public class OrderConsumedConsumablesBalanceView extends UserIdAbstractView {

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ITEM_ID")
    String itemId;

    @Column(name = "ITEM")
    String item;

    @Column(name = "SUM")
    BigDecimal sum;

    public StockBalance toStockBalance() {
        return new StockBalance(itemId, item, sum);
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
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
