package domain.models.enterprises;

import com.fasterxml.jackson.annotation.JsonFormat;
import domain.models.abstracts.TypographyTable;
import kpersistence.v1.mapping.annotations.Direction;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v1.mapping.annotations.OrderBy;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MONEY_MOVEMENTS")
public class MoneyMovement extends TypographyTable {

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
