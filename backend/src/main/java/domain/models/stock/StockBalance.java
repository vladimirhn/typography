package domain.models.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import repository.tables.StringIdTable;
import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Foreign;
import kpersistence.mapping.annotations.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "STOCK_BALANCE")
public class StockBalance extends StringIdTable {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "STOCK_ID")
    String stockId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

    @Foreign(table = ConsumableItem.class, foreignId = "consumableItemId")
    private String consumableItemName;

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

    public String getConsumableItemName() {
        return consumableItemName;
    }

    public void setConsumableItemName(String consumableItemName) {
        this.consumableItemName = consumableItemName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
