package domain.models.purchasing;

import domain.models.counterparties.LegalEntity;
import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.annotations.Column;
import kpersistence.annotations.Foreign;
import kpersistence.annotations.Table;
import rest.models.JsonNonNullUserIdStringIdTable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "PURCHASING_CONSUMABLES")
public class PurchasingConsumables extends JsonNonNullUserIdStringIdTable {

    @Column(name = "CONSUMABLE_ID", foreign = ConsumableItem.class, nonNull = true)
    private String consumableId;

    @Foreign
    private ConsumableItem consumableItem;

    @Column(name = "CAPACITY")
    private BigDecimal capacity;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "PURCHASING_DATE")
    private LocalDate purchasingDate;

    @Column(name = "LEGAL_ENTITY_ID", foreign = LegalEntity.class, nonNull = true)
    private String legalEntityId;

    @Foreign
    private LegalEntity legalEntity;

    public PurchasingConsumables() {}

    @Override
    public void setDefaults() {
        if (purchasingDate == null)
            purchasingDate = LocalDate.now();
    }

    public String getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(String consumableId) {
        this.consumableId = consumableId;
    }

    public ConsumableItem getConsumableItem() {
        return consumableItem;
    }

    public void setConsumableItem(ConsumableItem consumableItem) {
        this.consumableItem = consumableItem;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(LocalDate purchasingDate) {
        this.purchasingDate = purchasingDate;
    }

    public String getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(String legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }
}
