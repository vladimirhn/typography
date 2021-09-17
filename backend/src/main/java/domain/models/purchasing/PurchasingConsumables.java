package domain.models.purchasing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import repository.tables.TypoTable;
import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.mapping.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PURCHASING_CONSUMABLES")
public class PurchasingConsumables extends TypoTable {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CONSUMABLE_ID")
    private String consumableId;

    @Foreign(table = ConsumableItem.class, foreignId = "consumableId")
    private String consumableName;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "PURCHASING_DATE")
    @OrderBy(direction = Direction.DESC)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime purchasingDate;

    public PurchasingConsumables() {}

    @Override
    public void setDefaults() {
        if (purchasingDate == null)
            purchasingDate = LocalDateTime.now();
    }

    public String getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(String consumableId) {
        this.consumableId = consumableId;
    }

    public String getConsumableName() {
        return consumableName;
    }

    public void setConsumableName(String consumableName) {
        this.consumableName = consumableName;
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

    public LocalDateTime getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(LocalDateTime purchasingDate) {
        this.purchasingDate = purchasingDate;
    }
}
