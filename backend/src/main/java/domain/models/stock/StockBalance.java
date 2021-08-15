package domain.models.stock;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "STOCK_BALANCE")
public class StockBalance extends TypoTable {

    @Column(name = "STOCK_ID")
    String stockId;

    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

    @Column(name = "AMOUNT")
    BigDecimal amount;

    public StockBalance() {}

    public StockBalance(String consumableItemId, BigDecimal amount) {
        this.consumableItemId = consumableItemId;
        this.amount = amount;
    }

    @Override
    public void setDefaults() {
        stockId = "-1";
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getConsumableItemId() {
        return consumableItemId;
    }

    public void setConsumableItemId(String consumableItemId) {
        this.consumableItemId = consumableItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
