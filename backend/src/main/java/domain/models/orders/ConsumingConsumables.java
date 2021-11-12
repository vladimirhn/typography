package domain.models.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import kpersistence.mapping.annotations.*;
import repository.tables.UserIdStringIdTable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CONSUMING_CONSUMABLES")
public class ConsumingConsumables extends UserIdStringIdTable {

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "CONSUMING_DATE")
    @OrderBy(direction = Direction.DESC)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime consumingDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "CONSUMABLE_ID")
    private String consumableId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public ConsumingConsumables() {}

    @Override
    public void setDefaults() {
        if (consumingDate == null)
            consumingDate = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getConsumingDate() {
        return consumingDate;
    }

    public void setConsumingDate(LocalDateTime consumingDate) {
        this.consumingDate = consumingDate;
    }

    public String getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(String consumableId) {
        this.consumableId = consumableId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
