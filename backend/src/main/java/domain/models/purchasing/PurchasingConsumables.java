package domain.models.purchasing;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PURCHASING_CONSUMABLES")
public class PurchasingConsumables extends TypoTable {

    @Column(name = "PURCHASING_DATE")
    private LocalDateTime purchasingDate;

    @Column(name = "CONSUMABLE_ID")
    private Long consumableId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "PRICE")
    private BigDecimal price;

    public PurchasingConsumables() {}

    public LocalDateTime getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(LocalDateTime purchasingDate) {
        this.purchasingDate = purchasingDate;
    }

    public Long getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(Long consumableId) {
        this.consumableId = consumableId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
