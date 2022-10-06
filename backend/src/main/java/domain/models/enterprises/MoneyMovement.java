package domain.models.enterprises;

import com.fasterxml.jackson.annotation.JsonFormat;
import kpersistence.annotations.*;
import rest.models.JsonNonNullUserIdStringIdTable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "MONEY_MOVEMENTS")
public class MoneyMovement extends JsonNonNullUserIdStringIdTable {

    @Column(name = "TYPE")
    BigDecimal type;

    @Column(name = "AMOUNT")
    BigDecimal amount;

    @Column(name = "MOVEMENT_DATE")
    @OrderBy(direction = Direction.DESC)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @InsertDefault(dateTime = "now")
    private LocalDateTime movementDate;

    public MoneyMovement() {}

    @Override
    public void setDefaults() {
        movementDate = LocalDateTime.now();
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(LocalDateTime movementDate) {
        this.movementDate = movementDate;
    }
}
