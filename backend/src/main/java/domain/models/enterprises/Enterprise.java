package domain.models.enterprises;

import kpersistence.v2.annotations.Column;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v1.mapping.annotations.Label;
import kpersistence.v2.annotations.Table;
import kpersistence.v2.tables.UserIdStringIdTable;

import java.math.BigDecimal;

@Entity
@Table(name = "ENTERPRISES")
public class Enterprise extends UserIdStringIdTable {

    @Label
    @Column(name = "NAME")
    String name;

    @Column(name = "MAIN_ACCOUNT_BALANCE")
    BigDecimal mainAccountBalance;

    @Column(name = "DEPOSIT")
    BigDecimal deposit;

    @Column(name = "WITHDRAW")
    BigDecimal withdraw;

    public Enterprise() {}

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMainAccountBalance() {
        return mainAccountBalance;
    }

    public void setMainAccountBalance(BigDecimal mainAccountBalance) {
        this.mainAccountBalance = mainAccountBalance;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
    }
}
