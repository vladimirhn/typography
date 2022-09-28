package domain.models.enterprises;

import com.fasterxml.jackson.annotation.JsonFormat;
import rest.v2.models.JsonNonNullUserIdStringIdTable;
import kpersistence.v2.annotations.Direction;
import kpersistence.v2.annotations.OrderBy;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

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
    @JsonFormat(pattern = "dd.MM.yyyy")
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
