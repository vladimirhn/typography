package domain.models.stock;

import kpersistence.annotations.Column;

import java.math.BigDecimal;
import java.util.Objects;

public class StockBalance implements Comparable<StockBalance> {

    String itemId;

    @Column(name = "")
    String item;

    @Column(name = "")
    BigDecimal sum;

    public StockBalance() {
    }

    public StockBalance(String itemId, String item, BigDecimal sum, BigDecimal packageCapacity) {
        this.itemId = itemId;
        this.item = item;
        this.sum = sum.multiply(packageCapacity);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockBalance that = (StockBalance) o;
        return itemId.equals(that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public int compareTo(StockBalance o) {
        if (this.item == null) this.item = ""; //TODO: temporary NPE patch
        if (o.item == null) o.item = "";       //TODO: temporary NPE patch
        return this.item.compareTo(o.item);
    }
}
