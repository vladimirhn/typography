package domain.models.enterprises;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Label;
import kpersistence.mapping.annotations.Table;
import repository.tables.UserIdStringIdTable;

import java.math.BigDecimal;

@Entity
@Table(name = "ENTERPRISES")
public class Enterprise extends UserIdStringIdTable {

    @Label
    @Column(name = "NAME")
    String name;

    @Column(name = "MAIN_ACCOUNT_BALANCE")
    BigDecimal mainAccountBalance;

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
}
