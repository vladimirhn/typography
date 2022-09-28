package domain.models.enterprises;

import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Label;
import kpersistence.v2.annotations.Table;
import rest.v2.models.JsonNonNullUserIdStringIdTable;

import java.math.BigDecimal;

@Table(name = "ENTERPRISES")
public class Enterprise extends JsonNonNullUserIdStringIdTable {

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
