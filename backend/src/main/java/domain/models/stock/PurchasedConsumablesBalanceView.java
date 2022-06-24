package domain.models.stock;

import kpersistence.v2.annotations.Column;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Table;
import repository.v1.tables.UserIdAbstractView;

import java.math.BigDecimal;

@Entity
@Table(name = "PURCHASED_CONSUMABLES_BALANCE_VIEW")
public class PurchasedConsumablesBalanceView extends UserIdAbstractView {

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ITEM_ID")
    String itemId;

    @Column(name = "ITEM")
    String item;

    @Column(name = "SUM")
    BigDecimal sum;

    @Column(name = "PACKAGE_CAPACITY")
    BigDecimal packageCapacity;

    public StockBalance toStockBalance() {
        return new StockBalance(itemId, item, getSum(), packageCapacity);
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

    public BigDecimal getPackageCapacity() {
        return packageCapacity;
    }

    public void setPackageCapacity(BigDecimal packageCapacity) {
        this.packageCapacity = packageCapacity;
    }
}
