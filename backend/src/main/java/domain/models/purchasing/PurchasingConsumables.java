package domain.models.purchasing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import domain.models.abstracts.TypoTable;
import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Foreign;
import kpersistence.mapping.annotations.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PURCHASING_CONSUMABLES")
public class PurchasingConsumables extends TypoTable {

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CONSUMABLE_ID")
    private Long consumableId;

    @Foreign(table = ConsumableItem.class, foreignId = "consumableId")
    private String consumableName;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "PURCHASING_DATE")
    private LocalDate purchasingDate;

    public PurchasingConsumables() {
        purchasingDate = LocalDate.now();
    }

    public Long getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(Long consumableId) {
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

    public LocalDate getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(LocalDate purchasingDate) {
        this.purchasingDate = purchasingDate;
    }
}
